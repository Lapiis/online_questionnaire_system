<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>信息修改</title>
</head>
<c:import url="banner.jsp"/>
<body>

<a href="<c:url value="/manage/main" />">返回主页</a>
<h2>修改信息</h2>
<sf:form method="POST" modelAttribute="managerInfo">
    <sf:errors path="*" cssClass="error"/><br/><br/>
    用户名：<c:out value="${managerInfo.name}"/><br/><br/>
    <sf:hidden path="name" ></sf:hidden>
    密码：<sf:password path="password"/><sf:errors path="password" cssClass="error"/><br/><br/>
    邮箱：<sf:input path="email"/><sf:errors path="email" cssClass="error"/> <br/><br/>
    电话：<sf:input path="phoneNum"/><sf:errors path="phoneNum" cssClass="error"/><br/><br/>
    <input type="submit" value="修改"/>
</sf:form>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>
