<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<c:import url="banner.jsp"/>
<body>
<h1>登录</h1>
<form method="POST">
    用户名: <label><input type="text" name="name"/><br/><br/></label>
    　密码: <label><input type="password" name="password"/><br/><br/></label>
    <label><input type="checkbox" name="autoLoginTimeout" value="604800">7天内免登录</label><br/>
    <input type="submit" value="登录"/>
</form>
<br>
<a href="<c:url value="/" />">返回主页面</a>
<br/><br/>

</body>
<c:import url="footer.jsp"/>
</html>
