<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>创建问题</title>
</head>

<c:import url="banner.jsp"/>
<br/>
<c:choose>
    <c:when test="${question.type == 0}">
        <h2>创建问答题</h2>
    </c:when>
    <c:when test="${question.type == 1}">
        <h2>创建单选题</h2>
    </c:when>
    <c:otherwise>
        <h2>创建多选题</h2>
    </c:otherwise>
</c:choose>
<br/>

<body>

<c:if test="${question.type != 0}">
    <form method="POST">
        选项数量:<input type="number" name="optionCnt" required="required">
        <input type="hidden" name="newQuestion" value="false">
        <input type="hidden" name="qType" value="${question.type}">
        <input type="hidden" name="qid" value="${question.id}">
        <input type="submit" value="修改">
    </form>
</c:if>

<form method="POST" action="<c:url value="/user/question/save/${question.id}"/>">
    问题描述:<input type="text" name="description" required="required"><br/>
    <hr/>
    <c:if test="${question.type != 0}">
        请至少设置两个选项。<hr/>
        1. 选项描述 : <input type="text" name="option" required="required"><br/>
        2. 选项描述 : <input type="text" name="option" required="required"><br/>
        <c:forEach var="i" begin="3" end="${optionCnt}">
           ${i}. 选项描述 : <input type="text" name="option"><br/>
        </c:forEach>
    </c:if>
    <input type="submit" value="提交">
</form>
<br/>
<a href="<c:url value="/user/question/delete/${question.qnid}/${question.id}"/>">
    <button>返回</button>
</a>
<br><br>
</body>

<c:import url="footer.jsp"/>

</html>
