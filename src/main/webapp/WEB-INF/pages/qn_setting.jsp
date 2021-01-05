<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="SimpleTag" prefix="myTag" %>
<html>

<head>
    <title>问卷编辑</title>
    <meta charset="UTF-8">
</head>
<c:import url="banner.jsp"/>
<body>

<a href="<c:url value="/user/main"/>">
    <button>返回</button>
</a>

<h1>问卷编辑</h1>

<h2><c:out value="${questionnaireDetails.title}"/></h2>

<form method="post">
    修改问卷标题:
    <input type="text" name="title" required="required">
    <input type="submit" value="确认">
</form>


<ol class="questionList">
    <c:forEach items="${questionnaireDetails.questions.items}" var="question" varStatus="status">
        <li id="question_<c:out value="${question.id}"/>">
            <div class="description"><myTag:typeName type="${question.type}"/><c:out
                    value="${question.description}"/></div>
            <div class="option">
                <myTag:DO question="${question}"/>
            </div>
            <br/>
            <a href="<c:url value="/user/question/delete/${questionnaireDetails.id}/${question.id}"/>">
                <button>删除</button>
            </a>
            <hr/>
        </li>
    </c:forEach>
</ol>

<form method="POST" action="<c:url value="/user/question/create/${questionnaireDetails.id}"/>">
    <select name="qType">
        <option value="0">问答题</option>
        <option value="1">单选题</option>
        <option value="2">多选题</option>
    </select>
    <input type="hidden" name="newQuestion" value="true">
    <input type="submit" value="新增问题">
</form>

<br/><br/>

<a href="<c:url value="/user/questionnaire/show/${questionnaireDetails.id}"/>">
    <button>保存</button>
</a>
<br/><br/>
<a href="<c:url value="/user/questionnaire/post/${questionnaireDetails.id}"/>">
    <button>发布</button>
</a>