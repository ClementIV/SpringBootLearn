<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DBIS
  Date: 2019-05-02
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tag For Each</title>
</head>
<body>
<h2>c:forEach 标签</h2>
<table>
    <thead>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>住址</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items ="${studentList}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.addr}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>
</body>
</html>
