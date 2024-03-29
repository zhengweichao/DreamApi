# CHANGELOG

## [v0.0.5]  2023.03.21

- 增加: 数据安全保护数据加密方法
- 优化: post请求增加RequestBody设置
- 组件升级：
  - spring-boot -> 2.7.2
  - lombok -> 1.18.26
  - hutool -> 5.8.15
  - dinger -> 2.0.0

## [v0.0.4]  2022.06.15

- 增加: docker-compose配置
- 增加: mysql容器化配置以及数据初始化
- 优化: 代码生成模块代码优化
- 组件升级：
  - spring-boot -> 2.6.6
  - mybatis-plus-generator -> 3.5.2
  - lombok -> 1.18.24
  - hutool -> 5.8.2

## [v0.0.3]  2022.04.09

- 增加: 邮件发送功能；
- 增加: 钉钉消息发送功能；
- 增加: 定时任务功能；
- 增加: 频繁访问限制；
- 优化: 优化启动日志输出。

## [v0.0.2]  2022.03.19

- 增加: IP 访问策略配置，支持黑白名单设置；
- 增加: 数据库连接验证接口，并支持开关设置；
- 增加: 启动输出文档地址等信息；
- 增加: entity模板，隐藏逻辑删除字段；
- 修复: controller模板version重复bug。

## [v0.0.1]  2022.03.13

- 集成 spring boot 常用开发组件，并设置默认配置，开箱即用;
- 集成 mybatis plus ，可快速进行 dao 操作;
- 集成 mybatis plus generator，可快速生成代码；
- 集成 Swagger3，可自动生成 api 文档；
- 集成 Hutool 工具类库，封装常用工具信息。