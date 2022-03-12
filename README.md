# 1. 项目简介

🚀 API接口快速开发脚手架 - DreamApi

DreamApi 是一套集成 spring boot 常用开发组件的后台快速开发脚手架。 

本项目致力于降低新项目搭建成本，让每个人都可以高效搭建稳定API项目 ！

> 本项目尽可能采用最新的版本搭建，享受最新特性，且在项目中集成优秀的第三方组件，避免重复造轮子。

环境版本要求：

JDK: 17.0.1  +  MySQL: 8.0.27  +  Maven: 3.6.3

# 2. 主要特性

* 集成spring boot 常用开发组件集、公共配置、AOP日志等;
* 集成mybatis plus快速dao操作；
* 集成mybatis plus generator，可根据数据库表快速生成 CURD 代码;
* 集成Swagger3，自动生成 api 文档；
* 集成Hutool工具类库，提供大量开箱即用的工具类方法，提高工作效率；

# 3. 主要框架

本项目集成了大量的优秀的三方组件，此处仅列举部分项目，完整版详见 [libs.md](docs/libs.md)。
在此对这些项目以及项目的作者表示衷心的感谢。

* 核心框架：Spring Boot
* 持久层框架：MyBatis MyBatis Plus
* 工具类库：Hutool

# 4. 快速开始

### 4.1. 克隆 DreamApi

```bash
git clone https://github.com/zhengweichao/DreamApi.git
cd DreamApi
```

###  4.2. Maven 构建

> 默认使用 local 环境,对应配置文件：application-local.yml

```bash
mvn clean package
```

### 4.3. 快速实现生成代码

#### 4.3.1. 创建数据库表

```sql
CREATE TABLE `pro_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qt_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '题目标题',
  `qt_level` tinyint NOT NULL DEFAULT '1' COMMENT '难度等级[1高、2中、3低]',
  `qt_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '内容',
  `qt_ability` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '考验能力',
  `qt_type` tinyint DEFAULT '3' COMMENT '类型[1单选、2判断、3问答]',
  `qt_answer` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '答案概要',
  `qt_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint DEFAULT NULL COMMENT '更新人',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除[0否,1是]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='面试题目';
```
#### 4.3.2. 使用代码生成器生成增删改查代码

代码生成入口类，在`src/test/java/top/vchao/dream/generate`目录下。核心代码如下：

```java
GenCommon.getAutoGenerator(moduleName, tableName)
.strategyConfig(builder -> {
	builder.addFieldPrefix("qt_");
})
.execute();
```

如需进行自定义修改，则需要修改 GenCommon.java。



# 5. 交流、反馈、参与贡献

* E-mail：code@vchao.top
* GitHub：https://github.com/zhengweichao/DreamApi