<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="SimpleTag" prefix="myTag" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>问卷填写</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<c:import url="banner.jsp"/>
<body>
<div class="questionList">
    <h2>问卷标题：${questionnaireDetails.title}</h2>
    <form method="post">
        <ol class="questionList">
            <c:forEach items="${questionnaireDetails.questions.items}" var="question" varStatus="status">
                <li id="question_<c:out value="${question.id}"/>">
                    <div class="description"><myTag:typeName type="${question.type}"/><c:out value="${question.description}"/></div>
                    <div class="option">
                        <myTag:DO question="${question}"/>
                    </div>
                </li>
            </c:forEach>
        </ol>
        <input type="submit" value="提交问卷">
    </form>
</div>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>