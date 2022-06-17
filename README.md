# wali

🤖️ 家庭机器人-瓦力

## Steps

- Add dependencies
- Add annotation
- Coding
- Add configuration

## DB

### 初始化

```shell
docker run -p 3306:3306 --name wali-db --platform linux/x86_64 \
-v `pwd`/database-volume/log:/var/log/mysql \
-v `pwd`/database-volume/data:/var/lib/mysql \
-v `pwd`/database-volume/conf:/etc/mysql \ # 删除这行
-d mysql:latest

docker run -p 3306:3306 --name wali-db  \
-v `pwd`/database-volume/log:/var/log/mysql \
-v `pwd`/database-volume/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=ObviouslyFakePwd \
-d mariadb:latest
```

### 链接

```shell
$ docker exec -it wali-db bash


$ docker exec -it wali-db mysql -uroot -p
```

### SQL

```sql
CREATE
DATABASE robot_wali_dev;
    
USE robot_wali_dev;
DROP TABLE IF EXISTS `robot_wali_user`;
CREATE TABLE `robot_wali_user`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(64)  NOT NULL COMMENT 'user name',
    `password`    varchar(64)  NOT NULL COMMENT 'password',
    `create_at`   timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'create time',
    `modified_at` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP (6) COMMENT 'modified time',
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT = 'user';

```

### SpringBoot 与 Mybatis 集成
1. 添加依赖
```xml
<!--https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/-->
<!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.29</version>
</dependency>


```
2. 添加注解
- @Mapper
- @Select