# demo-servlet
basic training on how to build a servlet container 
1.本工程旨在教会初学者如何编写简单的servlet实例和JSP实例，实现最基本的http服务。
2.请结合教程https://www.runoob.com/jsp/eclipse-jsp.html 进行学习
3.关于自己编写的servlet实现类，实例如果在tomcat中的注册有两种方法 
1）通过在web.xml中配置节点来完成 
2）在实现类HelloServlet中使用@webservlet注解来实现 第1中方法的优先级更高。
   servlet响应客户端的请求，最终仍然是返回给客户端一个html资源。由客户端浏览器负责解析html和javascipt后，将内容渲染后展示给用户。
4.本工程下还放置了一个test.jsp实例，tomcat服务启动后，可以通过http://localhost:8080/demo-servlet/test.jsp来访问该服务。做这个实例是为了方便我们比较 servlet和jsp两种web服务的实现形式，jsp属于服务端的动态页面，需要被jvm编译成.class文件，jsp响应http请求的原理，最终任然是在后台转化成一个servlet实例来实现的。jsp中可以写html,javascript,java代码等多种语言。
5.关于countfilter的demo，过滤器同样支持注解式配置和web.xml中配置，但是奇怪的是，两者都配置的情况下，注解式配置的优先级更高，因此建议开发者仅选择一种配置方式即可，避免出现不可预测的问题。
