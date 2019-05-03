## Servlet Filter(过滤器)和Listener(监听器)

### Serverlet的概念：

用来处理客户端请求的动态资源，也就是当在浏览器中键入一个地址敲回车跳转后，请求就会发送到对应的Serverlet上进行处理。

### Servlet使用场景
* 接收请求数据
    * 客户端请求会被封装成HttpServeletRequest对象，里面包含了请求头、请求参数等各种信息。
* 处理请求
    * 通常会在Servlet的service、doPost或者doGet方法进行接收参数，并调用业务层（service）的方法来处理请求。
* 完成响应
    * 处理完请求后，一般会forward(转发)或者redirect（重定向）到某个页面，forward是HttpServletRequest中的方法，redirect是HttpServletResponse中的方法，两者是有很大的区别

### Filter的概念：
Filter中文翻译叫做拦截器，简单一句话就是用来拦截请求的。Filter可以用来转换HTTP请求，响应和头信息。

Filter不像Servlet,它不能产生一个请求或者响应，但是它能修改某些资源的请求数据或者修改某些资源的响应数据

### Filter使用场景如下

1. 拦截资源请求，进行资源访问控制、加解密等
2. 修改request头和request数据
3. 修改response和response数据

### Listener的概念：

Filter中文翻译叫做监听器，简单一句话就是用来监听某个对象的状态变化的主件、

### 监听器分类

按照被监听的对象和监听的内容分为两类

- | ServletContext域 | HttpSession域 | ServeletRequest域 
-|-|-|-
域的创建和销毁 | ServerContextListener |HttpSessionListener| ServletRequestListener
域对象内属性的变化| ServletContextAttributeListener | HttpSessionAttributeListener | ServletRequestAttributeListener

### Listener使用场景如下

1. 监听ServletContext HttpSession和ServletRequest创建和销毁
2. 监听ServletContext HttpSession和ServletRequest内部属性的变化

### WebServlet注解使用

```java
    @WebServlet(name="ServletAnnoation",urlPatterns ={"/servletAn"})
    public class ServletAnnoation extends HttpServlet{
        private static final long serialVersionUID = 55777711364564646
        
        private static final Logger logger = LoggerFactory.getLogger(ServletAnnotation.class)

        @Override
        protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException ,IOException{
            this.doPost(req,resq);
        }

        @Override
        protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
            logger.info("name={}",req.getParameter("name"));
            resp.getWriter().write("request Ok");
        }
    }
```

### 注解属性说明

属性名 | 类型 | 描述
-|-|-
name | String | 指定 Servlet的名称，等价于\<servlet-name>. <br/>如果没有显示指定，则该Servlet的取值即为类的全限定名
value | String[] |该属性等价于urlPatterns属性，两个属性不能同时使用。
urlPatterns | String[] | 指定一组Servlet的URL匹配模式，等价于\<url-pattern>标签
loadOnStartUp | int | 指定Servlet的加载顺序，等价于\<load-on-startup>标签
initParams | WebInitParam[] |指定一组Servlet初始化参数，等价于\<init-params>标签
asyncSupported | boolean | 声明Servlet是否支持异步操作模式，等价于\<async-supported>标签
description | String | 该Servlet的描述信息，等价于\<description>标签
displayName | String | 该Servlet的显示名，通常配合工具使用，等价于\<display-name>标签

### WebFilter注解使用代码及主要属性说明

```java
    @WebFilter(filterName ="filterAnnoation",urlPatterns ="/*")
    public class FilterAnnoation implements Filter{

        private static final Logger logger = LoggerFactory.getLogge(FilterAnnotation.class)

        @Override
        public void init(FilterConfig filterConfig) throws ServletException{
            return;
        }

        @Override
        public void doFilter(ServletRequest request,ServletResponse response ,FilterChain chain) throws IOException ,ServletException{
            HttpServletRquest req = (HttpServletRquest) request;
            logger.info("FilterAnnoation request uri="+ req.getRequstURI())
            chain.doFilter(request,response);
        }

        @Override
        public void destory(){
        }
    }
```

### WebFilter注解属性说明

属性名 | 类型 | 描述
-|-|-
filterName | String |指定过滤器的name属性，等价于\<filte-name>
value | String[] | 该属性等价于urlPatterns属性，但是两者不应该同时使用
urlPatterns | String[] |指定一组过滤器的URL匹配模式，等价于\<url-pattern>标签
servletNames | String[] | 指定过滤器将应用
dispatcherTypes| DispatcherType |指定过滤器的转发模式，具体取值包括：ASYNC,ERROR, FORWARD,INCLUDE,REQUEST.
initParams|WebInitParam[]| 指定一组过滤器初始化参数，等价于\<init-param>标签
asyncSupported | boolean | 声明过滤器是否支持异步操作模式，等价于\<async-support>标签
description | String | 该过滤器的描述信息，等价\<description>标签
displayName | String | 该过滤器的显示名，通常配合工具使用，等价于\<display-name>标签

* 多个过滤器执行顺序，以过滤的.java名字排序，字典顺序决定执行顺序，所以在定义FilterChain一定要注意这个规则。

### WebListener 

```java
    @WebListener
    public class ListenerAnnoation implements ServletRequestListener{
        private static final Logger logger = LoggerFactory.getLogger(ListenerAnnoation.class)

        @Override
        public void requestDestroyed(ServletRequestEvent  sre){
            logger.info("requestDestroyed");
        }

        @Override
        public void requestInitialized (ServletRequestEvent sre){
            logger.info("requestInitialized");
        }
    }
```

### WebListener注解属性说明

属性名| 类型|描述
-|-|-
value|String |该监听器的描述信息

### @ServletComponentScan

在启动类中看到ServerLetComponentScan 注解，该注解的作用是启动项目时扫描本包及其子包带有的WebsServlet, WebFilter和WebListener注解的类进行Servlet,Filter和Listener自动注册