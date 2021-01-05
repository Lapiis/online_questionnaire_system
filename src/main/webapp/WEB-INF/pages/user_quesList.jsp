<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户问卷列表</title>
</head>
<c:import url="banner.jsp"/>
<body>
<a href="<c:url value="/user/main" />">返回</a>
<h1>问卷列表</h1>
<div>
    <table style="border: black solid 1px">
        <tr>
            <th>问卷标题</th>
            <th>问卷创建日期</th>
            <th>问卷状态</th>
            <th></th>
            <th></th>
            <th>问卷链接</th>
        </tr>
        <c:if test="${questionnaireList!=null}">
            <c:forEach items="${questionnaireList.items}" var="q">
                <tr>
                    <td>${q.title}</td>
                    <td><fmt:formatDate value="${q.createTime}" type="both"/></td>
                    <td>
                        <c:if test="${q.status==0}">草稿</c:if>
                        <c:if test="${q.status==1}">待审核</c:if>
                        <c:if test="${q.status==2}">已发布</c:if>
                    </td>
                    <td>
                        <a href="<c:url value="/user/questionnaire/show/${q.id}"/> ">查看问卷</a>
                    </td>
                    <td>
                        <c:if test="${q.status==0}">
                            <a href="<c:url value="/user/questionnaire/modify/${q.id}"/> ">修改问卷</a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${q.status==2}">
                            <c:out value="${q.url}"/>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <br>
    <c:if test="${questionnaireList==null}">
        当前没有问卷
    </c:if>
</div>
<br><br><br><br>
<div>
    <a href="<c:url value="/user/questionnaire/create/${sessionScope.user.id}"/>">创建新问卷</a>
</div>
每页${questionnaireList.pageSize}项问卷，
第${questionnaireList.currentPageNo}/${questionnaireList.totalPageCount}页,共${questionnaireList.totalCount}项问卷
<c:if test="${questionnaireList.previousPage}">
    <a href="<c:url value="/user/questionnaire/questionnaireList?pageNo=${questionnaireList.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${questionnaireList.nextPage}">
    <a href="<c:url value="/user/questionnaire/questionnaireList?pageNo=${questionnaireList.currentPageNo+1}" />">下一页</a>
</c:if>
<br><br>
</body>
<c:import url="footer.jsp"/>
</html>
