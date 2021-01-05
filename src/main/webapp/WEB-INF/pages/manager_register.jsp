<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
    <title>新管理员</title>
</head>
<c:import url="banner.jsp"/>
<body>

<h2>新增管理员</h2>
<a href="<c:url value="/manage/managerList"/> ">返回</a>
<br><br>
<sf:form method="POST" modelAttribute="newManager">
    <sf:errors path="*" cssClass="error"/><br/><br/>
    用户名：<sf:input path="name"/><sf:errors path="name" cssClass="error"/><br/><br/>
    　密码：<sf:password path="password"/><sf:errors path="password" cssClass="error"/><br/><br/>
    　邮箱：<sf:input path="email"/><sf:errors path="email" cssClass="error"/> <br/><br/>
    　电话：<sf:input path="phoneNum"/><sf:errors path="phoneNum" cssClass="error"/> <br/><br/>
    <input type="submit" value="新增"/>
</sf:form>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>
