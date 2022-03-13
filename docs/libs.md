# 三方组件

本项目集成了大量优秀的三方组件， 在此对这些项目以作者表示衷心的感谢。

## 1. Spring Boot

> [官网](https://spring.io/projects/spring-boot)  |  [Github](https://github.com/spring-projects/spring-boot)  |  [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)

Spring Boot是由 Pivotal 团队提供的全新框架。其设计目的是用来简化新Spring应用的初始搭建以及开发过程。
该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。

本项目依赖多个组件：
- spring-boot-starter-freemarker：[Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-freemarker)
- spring-boot-starter-validation: [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
- spring-boot-starter-web: [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
- spring-boot-starter-test: [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)


## 2. MyBatis-Plus

> [官网](https://baomidou.com)   |   [Github](https://github.com/baomidou/mybatis-plus)  |  [Maven](https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter)

MyBatis-Plus （简称 MP）是一个  [MyBatis](https://www.mybatis.org/mybatis-3/) 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

- **无侵入**：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
- **损耗小**：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
- **强大的 CRUD 操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求

本项目依赖多个组件：
- mybatis-plus-boot-starter：[Maven](https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter)
- mybatis-plus-generator: [Maven](https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-generator)



## 3. Swagger

> [官网](https://swagger.io/)  |  [Github](https://github.com/swagger-api/swagger-core)  |  [Maven](https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter) 

Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。

总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法、参数和模型紧密集成到服务器端的代码，允许 API 来始终保持同步。Swagger 让部署管理和使用功能强大的 API 从未如此简单。

> 访问地址：http://localhost:8080/swagger-ui/



## 4. Lombok

> [官网](https://projectlombok.org/)  |  [Github](https://github.com/projectlombok/lombok)  | [Maven](https://mvnrepository.com/artifact/org.projectlombok/lombok)

Lombok 是一种 Java 实用工具，可用来帮助开发人员消除 Java 的冗长，尤其是对于简单的 Java 对象（POJO）。它通过注释实现这一目的。通过在开发环境中实现  Lombok，开发人员可以节省构建诸如 `hashCode()` 和 `equals()` 这样的方法以及以往用来分类各种 accessor 和 mutator 的大量时间。



## 5. Hutool

> [官网](https://www.hutool.cn/)  |  [ Github](https://github.com/looly/hutool)  |  [Maven](https://mvnrepository.com/artifact/cn.hutool/hutool-all)

Hutool是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。
