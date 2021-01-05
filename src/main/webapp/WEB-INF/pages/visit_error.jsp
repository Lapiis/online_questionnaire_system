<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Error</title>
</head>
<img src="${pageContext.request.contextPath}/images/java.png" alt="加载不出图片"/>
<body>

<h1>访问失败</h1><br><br>
<h4>找不到页面哦</h4>
<br><br><br>
</body>

<c:import url="footer.jsp"/>
</html>
