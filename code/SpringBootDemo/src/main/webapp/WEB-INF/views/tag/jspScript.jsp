<%--
  Created by IntelliJ IDEA.
  User: DBIS
  Date: 2019-04-26
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Script</title>
</head>
<body>
    <%
        String str[] = {"a","b","c","d"};
        for(int i=0;i<str.length;i++){
            out.write(str[i]);

    %>
    <br/>
    <% } %>
    <%! String name="乔峰";%>
    <p> 我是:<%= name%></p>
</body>
</html>
