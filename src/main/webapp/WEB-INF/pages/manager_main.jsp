<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>管理员主页</title>
</head>
<c:import url="banner.jsp"/>
<body>
<br>

<div>
    <a href="<c:url value="/manage/logout" />">注销</a>
</div>
<br><br><br>

<div>
    <a href="<c:url value="/manage/infoM/${sessionScope.manager.id}" />">个人信息</a>
</div>
<br><br><br>

<div>
    <a href="<c:url value="/manage/managerList"/>">管理员列表</a>
</div>
<br><br><br>

<div>
    <a href="<c:url value="/manage/userList"/>">用户列表</a>
</div>
<br><br><br>

<div>
    <a href="<c:url value="/manage/questionnaire/questionnaireList"/>">问卷列表</a>
</div>
<br><br><br>
<c:import url="footer.jsp"/>
</body>
</html>
