<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:import url="banner.jsp"/>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.user && not empty sessionScope.user.id }">
        <a href="<c:url value="/user/main" />">用户个人主页</a> |
        <a href="<c:url value="/user/logout" />">注销</a>
    </c:when>
    <c:when test="${not empty sessionScope.manager && not empty sessionScope.manager.id }">
        <a href="<c:url value="/manage/main" />">管理员主页</a> |
        <a href="<c:url value="/manage/logout" />">注销</a>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/user/login" />">登录</a> |
        <a href="<c:url value="/user/register" />">注册</a>
        <a href="<c:url value="/manage/login" />">管理员登录</a>
    </c:otherwise>
</c:choose>
<br/><br><br>

</body>
<c:import url="footer.jsp"/>
</html>
