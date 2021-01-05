<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>


<html>
<c:import url="banner.jsp"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>修改用户信息</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<a href="<c:url value="/manage/userList" />">返回管理页面</a>
<h1>修改用户信息</h1>

<sf:form method="POST" modelAttribute="user">
    <sf:errors path="*" cssClass="error"/><br/><br/>
    用户名：<sf:input path="name"/><sf:errors path="name" cssClass="error"/> <br/><br/>
    密码：<sf:password path="password"/><sf:errors path="password" cssClass="error"/><br/><br/>
    邮箱：<sf:input path="email"/><sf:errors path="email" cssClass="error"/> <br/><br/>
    电话：<sf:input path="phoneNum"/><sf:errors path="phoneNum" cssClass="error"/><br/><br/>
    <input type="submit" value="修改"/>
</sf:form>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>
