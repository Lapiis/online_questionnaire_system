<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="SimpleTag" prefix="myTag"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>问卷详情</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<c:import url="banner.jsp"/>
<body>
    <a href="<c:url value="/user/questionnaire/questionnaireList" />">返回</a>
    <div class="questionnaire">
        <h2>问卷标题：${questionnaireDetails.title}</h2>
        创建时间：<fmt:formatDate value="${questionnaireDetails.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
        <c:choose>
            <c:when test="${questionnaireDetails.status == 0}">
                当前为草稿
            </c:when>
            <c:when test="${questionnaireDetails.status == 1}">
                问卷待审核，请稍等
            </c:when>
            <c:otherwise>
                审核已通过，请分享您的链接：${questionnaireDetails.url}<br>
                审核时间：${questionnaireDetails.checkTime}
            </c:otherwise>
        </c:choose>
        <ol class="questionList">
            <c:forEach items="${questionnaireDetails.questions.items}" var="question" >
                <li id="question_<c:out value="${question.id}"/>">
                    <div class="type"><myTag:typeName type="${question.type}"/></div>
                    <div class="description"><c:out value="${question.description}" /></div>
                    <div class="option">
                        <myTag:DO question="${question}"/>
                    </div>
                    <c:if test="${question.type!=0}">
                        <a href="<c:url value="/user/questionnaire/stats/${question.id}" />">
                            <button>查看统计</button>
                        </a>
                    </c:if>
                </li>
            </c:forEach>
        </ol>
    </div>
    每页${questionnaireDetails.questions.pageSize}道问题，
    第${questionnaireDetails.questions.currentPageNo}/${questionnaireDetails.questions.totalPageCount}页,共${questionnaireDetails.questions.totalCount}道问题
    <c:if test="${questionnaireDetails.questions.previousPage}">
        <a href="<c:url value="/user/questionnaire/questionnaireList?pageNo=${questionnaireDetails.questions.currentPageNo-1}" />">上一页</a>
    </c:if>
    <c:if test="${questionnaireDetails.questions.nextPage}">
        <a href="<c:url value="/user/questionnaire/questionnaireList?pageNo=${questionnaireDetails.questions.currentPageNo+1}" />">下一页</a>
    </c:if>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
