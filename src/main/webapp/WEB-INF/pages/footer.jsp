<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Date Now</title>
</head>
<body>
<div>
    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd"/>
</div>
</body>
</html>
