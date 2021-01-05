<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div>
        <img src="${pageContext.request.contextPath}/images/oqs.jpg" width="50" height="50">
        <c:choose>
            <c:when test="${sessionScope.user.name!=null}">
                <h1>欢迎您，${sessionScope.user.name}!</h1>
            </c:when>
            <c:when test="${sessionScope.manager.name != null}">
                <h1>欢迎您，${sessionScope.manager.name}!</h1>
            </c:when>
            <c:otherwise>
                <h1>欢迎使用在线问卷系统!</h1>
            </c:otherwise>
        </c:choose>
</div>
</body>
</html>
