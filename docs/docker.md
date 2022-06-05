# Docker运行

```shell
# 构建镜像
docker build -t api:v1 .

# 运行容器
docker run -d -p 8080:8080 --name api api:v1
```