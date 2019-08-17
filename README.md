# gkzcode community

##技术选型

Spring Boot

Spring MVC

MyBatis

MySql,H2

Flyway

Heroku

git/github

maven

restful

bootstrap

Thymeleaf

uml关系图

##资料

[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[es](https://elasticsearch.cn/explore)

[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)

[Bootstrap](https://v3.bootstrap.com/getting-started/)

[Github OAuth](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)

[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)

##工具

[Git](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com)

[FlyWay](https://flywaydb.org/getstarted/firststeps/maven)

[lombok](https://www.projectlombok.org/features/all)

##脚本

```sql
create table user
(
	id int auto_increment,
	account_id varchar(100),
	name varchar(50),
	token char(36),
	gmt_create bigint,
	gmt_modified bigint,
	constraint user_pk
		primary key (id)
);

create table question
(
	id int auto_increment,
	title varchar(50),
	description text,
	gmt_create bigint,
	gmt_modified bigint,
	creator int,
	comment_count int default 0,
	view_count int default 0,
	like_count int default 0,
	tag varchar(256),
	constraint question_pk
		primary key (id)
);



```

```
bash
mvn flyway:migrate
```
