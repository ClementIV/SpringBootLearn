<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
  Created by IntelliJ IDEA.
  User: DBIS
  Date: 2019-05-02
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tag IF</title>
</head>
<body>
<h2>c:if标签</h2>
<c:if test="${userName!=null}">
    用户名：${userName}
</c:if>
</body>
</html>
