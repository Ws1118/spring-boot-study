## Spring

### Spring Boot产生的背景和它的设计理念

- Spring发展历史

  2002年10月 Rod Johnso写了一本书《Expert One-on-One
  J233》,提出了一个依赖注入的概念。书中他在不使用EJB的情况下，写了30000多行的基础代码，代码根包命名为com.interface21。2003年的时候，Rod Johnson给这个框架起了个名字Spring。

- Spring Boot的诞生

  Spring的一个很大问题就是需要大量的配置和依赖管理。Spring每集成一个开源软件，就需要增加基础配置，后来人们直接称呼Spring为配置地狱。为了解决这个问题，2013年，Pivotal的CTO提出了实现免XML配置的开发体验。对于已经熟悉Spring生态系统的开发人员来说，Spring
  Boot是一个很理想的选择，对于采用Spring技术的新人来说，Spring提供了一种更简洁的方式来使用。

- 约定优于配置

  约定优于配置（Convention Over Configration）:开发人员仅需规定应用中不符合约定的部分，对于符合约定部分直接不用处理。这样就不需要做大量的配置了。

- Starters

  Spring Boot
  Starter有两个核心组件：自动配置代码和提供自动配置代码及其它有用依赖，也就是说，当项目中引入某个Starter，就可以使用这个Starter的功能，除非和默认功能不一样的地方需要单独配置，否则不需要做任何配置。

    - Spring Boot Starts[列表](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter)

### Spring的特点:[Why Spring](https://spring.io/why-spring)

- Spring创建项目：[spring initializr](https://start.spring.io/)
    - language：Java、Kotlin、Groovy（Java版本只有8、11、15是因为是长期维护版本，较稳定）
    - [版本号后面字母的含义](https://blog.csdn.net/lizhenglyg/article/details/103147623?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161466363616780274148581%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=161466363616780274148581&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-3-103147623.first_rank_v2_pc_rank_v29&utm_term=%E7%89%88%E6%9C%AC%E5%8F%B7M2)

- Spring项目类型：[view all project](https://spring.io/projects)

- 浏览器快捷键：打开新标签页ctrl+t、关闭当前页ctrl+w、新开窗口ctrl+n

- Chrome应用商店安装插件LiveReload

-
Spring组成[Spring全面详解](https://blog.csdn.net/weixin_44207403/article/details/106736102?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161464286216780262561279%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=161464286216780262561279&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-1-106736102.first_rank_v2_pc_rank_v29&utm_term=spring)![image-20210302190738281](
C:
\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302190738281.png)![image-20210302190805804](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302190805804.png)

- 发展历程：JSP、SSH、SSM、SpringBoot、SpringCloud

- SpringBoot特点：

    - **容灾**

    - 遵循“约定优于配置”的原则，简化配置

    - 可以完全脱离XML配置文件,采用注解配置和java Config

    - 内嵌Servlet容器，应用可用jar包执行：java -jar

    - 快速完成项目搭建、整合第三方类库，方便易用

    - 提供了starter POM, 能够非常方便的进行包管理, 简化包管理配置

    - 与Spring cloud天然集成，spring boot是目前java体系内实现微服务最佳方案

### Spring Boot集成第三方类库的步骤

- 通过maven引入springboot-XXXX-starter
- 修改yaml或properties全局统一配置文件
- 加入一个Java Config。这个属于个性化配置，如果使用通用配置，这一步不需要。

## IDEA

- 项目对象模型POM(project object model)是Maven对一个单一项目的描述
-
项目结构目录符合maven规范要求![image-20210302190406272](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302190406272.png)

### 插件

#### lombok提高开发效率必备工具

- 打开Setting->Plugins，搜索“lombok”，点击Install，然后重启 IDEA

- 在pom.xml里面加上如下依赖，使插件生效

  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
  </dependency>
  ```

- Maven窗口刷新

#### JRebel插件

- 在` On ‘Update’ action `中换选` update classes and resources `

![image-20210302194036918](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302194036918.png)

#### devtools实现热加载

- 添加maven依赖

  ```html
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-devtools</artifactId>
     <optional>true</optional>
  </dependency>
  ```

#### Codota

- 极其强大的代码自动补全

#### Auto filling Java call arguments

- 安装完该插件以后，调用一个方法，使用 Alt+Enter 组合键，调出 ` Auto fill call parameters `自动使用该函数定义的参数名填充

#### GsonFormatPlus

- 将JSON转换为实体类(Alt+S启动)

#### Rainbow Brackets

- 代码由于括号太多，不确定当前代码行是否属于某个代码块，此时这个插件就会帮上大忙

#### Maven Helper

- 安装后，直接打开pom文件，即可查看依赖树，还能自动分析是否存在jar包冲突

#### Key promoter X

- 提示某鼠标操作可用快捷键代替

#### Grep Console

-
通过expression表达式过滤日志、给不同级别的日志或者给不同pattern的日志加上背景颜色与上层颜色![image-20210302201351425](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302201351425.png)

#### Background Image Plus

- 添加背景图![image-20210302201447948](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302201447948.png)
- 效果![image-20210302201622961](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302201622961.png)

#### RestfulTool

- 是一套Restful服务开发的辅助工具集，会在右侧有个面板，列出所有接口

#### .gitignore

- 在提交项目到本地仓库的时候，会把.idea文件夹中的内容也提交上去，这里面放的是一些项目的配置信息，包括历史记录，版本控制信息等。可以不传到Git上面去,还有其他的如target目录，一些账号配置文件等，都不要提交。
- 这个时候就需要编写.gitignore文件来忽略提交这些文件，在IDEA中的插件.ignore可以帮我们做这件事。

#### Alibaba Cloud Toolkit

- 帮助开发者高效开发并部署适合在云端运行的应用

#### Alibaba Java Coding Guidelines

- 插件在扫描代码后，将不符合规约的代码显示出来，甚至还基于 Inspection 机制提供了实时检测功能，编写代码的同时也能快速发现问题所在，还实现了批量一键修复的功能

#### IDEA 热更新

- 运行时编译配置：组合键：“Shift+Ctrl+Alt+/” ，选择 “Registry”
  ，选中打勾 ` compiler.automake.allow.when.app.running `![image-20210302194623096](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302194623096.png)
-
打开Setting，勾选` Build project automatically `![image-20210302194750857](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302194750857.png)
- 在` On ‘Update’ action `
  中换选` update classes and resources `![image-20210302194036918](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\image-20210302194036918.png)
- 每次修改完代码按Ctrl+F9更新

## 课后问题

- SSH是` struts+spring+hibernate `
  的一个集成框架。[SSH框架总结](https://blog.csdn.net/weixin_38911591/article/details/100242710?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161466737816780262573586%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=161466737816780262573586&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-1-100242710.first_rank_v2_pc_rank_v29&utm_term=ssh%E6%A1%86%E6%9E%B6)

- 后端除了tomcat还有那些web容器？

  JBoss 、 WebLogic、WebSphere [几种常见web容器](https://www.cnblogs.com/kaleidoscope/p/9668646.html)

