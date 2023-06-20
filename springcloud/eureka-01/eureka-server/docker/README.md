使用Docker部署eureka-server步骤：
1. maven打包jar包
2. 编写Dockerfile文件
3. 编写sh脚本文件
4. 将文件上传到服务器某空文件夹下（/root/eureka-server-test/eureka-server）
5. 授予sh文件权限 `chmod 777 run.sh`
6. 运行sh文件 `./run.sh`
7. 运行docker容器 `docker run --name eureka-server -p 8761:8761 -d eureka-server:1.0`
8. 开放防火墙`8761`端口
9. 访问 `ip + 8761`