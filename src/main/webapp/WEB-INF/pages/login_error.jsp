<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<c:import url="banner.jsp"/>
<body>
<h2>登录有误，请重新尝试</h2>
<a href="<c:url value="/user/login" />">登录</a> |
<a href="<c:url value="/user/register" />">注册</a> |
<a href="<c:url value="/manage/login" />">管理员登录</a>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
