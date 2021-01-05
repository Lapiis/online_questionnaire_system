<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<c:import url="banner.jsp"/>
<body>
<h1>注册失败，用户名不能重复</h1>
<br><br>
<c:choose>
    <c:when test="${sessionScope.manager!=null}">
        <a href="<c:url value="/manage/register" />">返回注册</a>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/user/register" />">返回注册</a>
    </c:otherwise>
</c:choose>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
