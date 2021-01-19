# SpringShiro使用指南

### 一、 前言
    作为JAVA程序员，在工作中实现业务系统的时候，经常要考虑系统权限的问题。
    一般情况下，JAVA程序员常使用权限框架有SpringSecurity和Shiro，
    因大家普遍认为Shiro比较轻量灵活，适合更一般的场景，所以我内心更倾向于使用Shiro作为权限框架。
    在之前的项目中，尝试使用过Shiro，但并未深入了解其机制。
    现在我正在开发一个自用的CMS系统，为了评估shiro是否适合引入，对shiro的机制进行了深入了解。
    在我深入了解的过程中，发现网上的教程虽然原理图很多，实例代码也很多，但并不能很好的讲解清楚其机制，
    于是我把我的经验写出来，以期望看到我的文章的人尽可能避免在迷惑中踩坑。

### 二、 SpringMvc集成实例
    Shiro提供shiro-web包用于SpringMvc的集成,该方案同样适用于使用SpringMvc机制的SpringBoot（不适用与WebFlux模式）
#### 1. 在pom.xml中加入spring-shiro的依赖

```xml
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring</artifactId>
    <version>1.7.0</version>
</dependency>
```
#### 2. spring配置
    此处为JavaConfig配置，由于配置均为定义Bean的配置，xml方式参照配置即可。
```java

```