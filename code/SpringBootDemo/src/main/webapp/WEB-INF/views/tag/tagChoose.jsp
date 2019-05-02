<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%--
  Created by IntelliJ IDEA.
  User: DBIS
  Date: 2019-05-02
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tag Choose</title>
</head>
<body>
<h2>c:choose 标签</h2>
<c:choose>
    <c:when test="${age<18}"> 少年 </c:when>
    <c:when test="${age>=18&&age<35}"> 青年 </c:when>
    <c:when test="${age>=35&&age<50}"> 壮年 </c:when>
    <c:otherwise> 老年</c:otherwise>
</c:choose>
</body>
</html>
