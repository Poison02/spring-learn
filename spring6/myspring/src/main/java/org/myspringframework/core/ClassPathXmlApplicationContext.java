package org.myspringframework.core;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zch
 * @data 2023/6/23
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象
     *
     * @param configLocation spring配置文件的路径吗，注意：使用ClassPathXmlApplicationContext，配置文件应该放在类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析myspring.xml，实例化Bean，将Bean存放到map中
            // 这是dom4j解析xml文件的核心对象
            SAXReader saxReader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 读文件
            Document document = saxReader.read(inputStream);
            // 获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历bean标签
            nodes.forEach(node -> {
                try {
                    // 向下转型，使用Element更丰富的方法
                    Element element = (Element) node;
                    // 获取id属性
                    String id = element.attributeValue("id");
                    // 获取class属性
                    String className = element.attributeValue("class");
                    logger.info("beanName=" + id);
                    logger.info("beanClassName=" + className);
                    // 使用反射机制创建对象，放到Map集合中，提前曝光
                    // 获取class
                    Class<?> aClass = Class.forName(className);
                    // 获取无参构造方法
                    Constructor<?> defaultCon = aClass.getDeclaredConstructor();
                    // 调用无参构造方法实例化Bean
                    Object bean = defaultCon.newInstance();
                    // 将Bean曝光，加入Map集合
                    singletonObjects.put(id, bean);
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次遍历所有bean，给对象属性赋值
            nodes.forEach(node -> {
                try {
                    Element element = (Element) node;
                    // 获取id属性
                    String id = element.attributeValue("id");
                    // 获取class属性
                    String className = element.attributeValue("class");
                    // 获取class
                    Class<?> aClass = Class.forName(className);
                    // 获取标签下所有的属性 property
                    List<Element> properties = element.elements("property");
                    // 遍历所有属性白哦前
                    properties.forEach(property -> {
                        try {
                            // 获取属性名
                            String propertyName = property.attributeValue("name");
                            // 获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            logger.info("propertyName=" + propertyName);
                            // 获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // 获取set方法
                            Method methodName = aClass.getDeclaredMethod(setMethodName, field.getType());
                            // 获取具体的值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            Object actualValue = null;
                            if (value != null) {
                                // 说明是简单类型
                                // 调用set方法 (set方法没有返回值)，哪个对象，传什么值
                                // 声明一下，只支持这些类型 八种基本类型 八种包装类型以及String
                                // 获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte": case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "short": case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "int": case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "long": case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "float": case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "double": case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "boolean": case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "char": case "Character":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;
                                }

                                methodName.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (ref != null) {
                                // 非简单类型
                                // 调用set方法 (set方法没有返回值)，哪个对象，传什么值
                                methodName.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
