<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Error</title>
</head>
<c:import url="banner.jsp"/>
<body>

<h2>删除失败，不能自己删除自己</h2><br><br>
<a href="<c:url value="/manage/managerList" />">返回列表</a>
<br><br><br>
</body>

<c:import url="footer.jsp"/>
</html>
