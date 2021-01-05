<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>问卷列表</title>
</head>
<c:import url="banner.jsp"/>
<body>

<a href="<c:url value="/manage/main" />">返回主页</a>
<div class="questionnaireList">
    <h2>问卷列表</h2>
    <table style="border: black solid 1px">
        <tr>
            <th>标题</th>
            <th>创建时间</th>
            <th>审核</th>
            <th>审核时间</th>
        </tr>
        <c:forEach items="${questionnaireList.items}" var="questionnaire">
            <tr>
                <td><c:out value="${questionnaire.title}"/></td>
                <td><fmt:formatDate value="${questionnaire.createTime}" type="both"/></td>
                <c:if test="${questionnaire.status==1}">
                    <td><a href="<c:url value="/manage/checkPage/${questionnaire.id}"/>">审核</a></td>
                    <td></td>
                </c:if>
                <c:if test="${questionnaire.status==2}">
                    <td><c:out value="已审核"/></td>
                    <td><fmt:formatDate value="${questionnaire.checkTime}" type="both"/></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

每页${questionnaireList.pageSize}项问卷，
第${questionnaireList.currentPageNo}/${questionnaireList.totalPageCount}页,共${questionnaireList.totalCount}项问卷
<c:if test="${questionnaireList.previousPage}">
    <a href="<c:url value="/manage/questionnaire/questionnaireList?pageNo=${questionnaireList.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${questionnaireList.nextPage}">
    <a href="<c:url value="/manage/questionnaire/questionnaireList?pageNo=${questionnaireList.currentPageNo+1}" />">下一页</a>
</c:if>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>