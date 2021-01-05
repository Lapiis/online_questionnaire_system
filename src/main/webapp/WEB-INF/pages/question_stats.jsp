<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="SimpleTag" prefix="myTag"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>问题统计</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<c:import url="banner.jsp"/>
<body>
<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
<div class="questionnaire">
    <h2>问题统计</h2>
    <br><br>
        <div>
            <img src="/DisplayChart?filename=${barChart}"  border="0"/>
        </div>
        <div>
            <img src="/DisplayChart?filename=${pieChart}"  border="0"/>
        </div>

<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
