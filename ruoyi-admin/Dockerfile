#基础镜像
FROM findepi/graalvm:java17-native

# 设置环境变量
ENV LANG C.UTF-8
ENV LANGUAGE C.UTF-8
ENV LC_ALL C.UTF-8
ENV SERVER_PORT=6039

# 设置工作目录
WORKDIR /app

# 打印当前目录
RUN pwd
COPY ./target/ruoyi-admin.jar ./app.jar

EXPOSE ${SERVER_PORT}

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
            # 应用名称 如果想区分集群节点监控 改成不同的名称即可
#            "-Dskywalking.agent.service_name=ruoyi-server", \
#            "-javaagent:/ruoyi/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]


