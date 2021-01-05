<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <title>管理员列表</title>
</head>
<c:import url="banner.jsp"/>
<body>

<a href="<c:url value="/manage/main" />">返回主页</a>
<br><br>
<div class="managerList">
    <h2>管理员列表</h2>
    <a href="<c:url value="/manage/register" />">
        <button>添加新管理员</button>
    </a>
    <table style="border: black solid 1px">
        <tr>
            <th>管理员名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${managerList.items}" var="manager">
            <tr>
                <td><c:out value="${manager.name}"/></td>
                <td><c:out value="${manager.phoneNum}"/></td>
                <td><c:out value="${manager.email}"/></td>
                <td><a href="<c:url value="/manage/infoM/${manager.id}"/>">修改信息</a></td>
                <c:if test="${manager.id!=sessionScope.manager.id}">
                    <td><a href="<c:url value="/manage/deleteM/${manager.id}"/>">删除</a></td>
                </c:if>

            </tr>
        </c:forEach>
    </table>
</div>

每页${managerList.pageSize}位管理员， 第${managerList.currentPageNo}/${managerList.totalPageCount}页,共${managerList.totalCount}位管理员
<c:if test="${managerList.previousPage}">
    <a href="<c:url value="/manage/managerList?pageNo=${managerList.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${managerList.nextPage}">
    <a href="<c:url value="/manage/managerList?pageNo=${managerList.currentPageNo+1}" />">下一页</a>
</c:if>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>