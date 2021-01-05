<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<c:import url="banner.jsp"/>
<body>
<h1>管理者登录</h1>
<form method="POST">
    用户名: <input type="text" name="name"/><br/><br/>
    　密码: <input type="password" name="password"/><br/><br/>
    <input type="submit" value="登录"/>
</form>
<a href="<c:url value="/" />">返回主页面</a><br/>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>
