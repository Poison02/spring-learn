package cdu.zch.bank.util;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 工具类：可以动态的生成Dao实现类
 *
 * @author Zch
 * @data 2023/6/24
 **/
public class GenerateDaoProxy {

    /**
     * 生成DAO接口实现类，并且将实现类的的对象创建出来并返回
     *
     * @param daoInterface dao接口
     * @return dao接口实现类的实例化对象
     */
    public static Object generate(SqlSession sqlSession, Class daoInterface) {

        ClassPool pool = ClassPool.getDefault();
        // 生成代理类
        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");
        // 接口
        CtClass ctInterface = pool.makeClass(daoInterface.getName());
        // 代理类实现接口
        ctClass.addInterface(ctInterface);
        // 获取所有的方法
        Method[] methods = daoInterface.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            // 拼接方法的签名
            StringBuilder methodStr = new StringBuilder();
            String returnTypeName = method.getReturnType().getName();
            methodStr.append(returnTypeName);
            methodStr.append(" ");
            String methodName = method.getName();
            methodStr.append(methodName);
            methodStr.append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                methodStr.append(parameterTypes[i].getName());
                methodStr.append(" arg");
                methodStr.append(i);
                if (i != parameterTypes.length - 1) {
                    methodStr.append(",");
                }
            }
            methodStr.append("){");
            // 方法体当中的代码怎么写？
            // 获取sqlId，主要是因为我框架开发人员不知道sqlId，所以我必须强制规定！
            // （这里非常重要：因为这行代码导致以后namespace必须是接口的全限定接口名，
            // sqlId必须是接口中方法的方法名。）
            String sqlId = daoInterface.getName() + "." + methodName;
            // 获取SqlCommandType
            String sqlCommandTypeName = sqlSession.getConfiguration().getMappedStatement(sqlId).getSqlCommandType().name();
            if ("SELECT".equals(sqlCommandTypeName)) {
                methodStr.append("org.apache.ibatis.session.SqlSession sqlSession = cdu.zch.bank.util.SqlSessionUtil.openSession();");
                methodStr.append("Object obj = sqlSession.selectOne(\"" + sqlId + "\", arg0);");
                methodStr.append("return (" + returnTypeName + ")obj;");
            } else if ("UPDATE".equals(sqlCommandTypeName)) {
                methodStr.append("org.apache.ibatis.session.SqlSession sqlSession = cdu.zch.bank.util.SqlSessionUtil.openSession();");
                methodStr.append("int count = sqlSession.update(\"" + sqlId + "\", arg0);");
                methodStr.append("return count;");
            }
            methodStr.append("}");
            System.out.println(methodStr);
            try {
                // 创建CtMethod对象
                CtMethod ctMethod = CtMethod.make(methodStr.toString(), ctClass);
                ctMethod.setModifiers(Modifier.PUBLIC);
                // 将方法添加到类
                ctClass.addMethod(ctMethod);
            } catch (CannotCompileException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            // 创建代理对象
            Class<?> aClass = ctClass.toClass();
            Constructor<?> defaultCon = aClass.getDeclaredConstructor();
            Object o = defaultCon.newInstance();
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
