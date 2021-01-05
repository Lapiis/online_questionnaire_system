<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="SimpleTag" prefix="myTag" %>
<html>
<head>
    <title>审核问卷</title>
</head>
<c:import url="banner.jsp"/>
<body>

<a href="<c:url value="/manage/questionnaire/questionnaireList" />">取消审核</a><br>
<div class="questionnaire">
    <h2>问卷标题：${questionnaireDetails.title}</h2>
    创建时间：${questionnaireDetails.createTime}<br>
    作者：${questionnaireDetails.username}<br><br>
    <h4>详情:</h4>
    <ol class="questionList">
        <c:forEach items="${questionnaireDetails.questions.items}" var="question">
            <li id="question_<c:out value="${question.id}"/>">
                <div class="type"><myTag:typeName type="${question.type}"/></div>
                <div class="description"><c:out value="${question.description}"/></div>
                <div class="option">
                    <c:if test="${question.type!=0}">
                        <c:forEach items="${question.options}" var="option">
                            ${option.answer}<br/>
                        </c:forEach><br>
                    </c:if>
                </div>
            </li>
        </c:forEach>
    </ol>
</div>
<br><br>
每页${questionnaireDetails.questions.pageSize}道问题，
第${questionnaireDetails.questions.currentPageNo}/${questionnaireDetails.questions.totalPageCount}页,共${questionnaireDetails.questions.totalCount}道问题
<c:if test="${questionnaireDetails.questions.previousPage}">
    <a href="<c:url value="/manage/questionnaire/questionnaireList?pageNo=${questionnaireDetails.questions.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${questionnaireDetails.questions.nextPage}">
    <a href="<c:url value="/manage/questionnaire/questionnaireList?pageNo=${questionnaireDetails.questions.currentPageNo+1}" />">下一页</a>
</c:if>
<br><br>
<div>
    <a href="<c:url value="/manage/checkQ/${questionnaireDetails.id}?mid=${sessionScope.manager.id}"/>">
        <button>通过</button>
    </a> |
    <a href="<c:url value="/manage/deleteQ/${questionnaireDetails.id}"/>">
        <button>删除</button>
    </a>
</div>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
