<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<c:import url="banner.jsp"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
<a href="<c:url value="/manage/main" />">返回主页</a>
<div class="UserList">
    <h2>用户列表</h2>
    <table style="border: black solid 1px">
        <tr>
            <th>用户名</th>
            <th>电话</th>
            <th>邮箱</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${userList.items}" var="user">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.phoneNum}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><a href="<c:url value="/manage/infoU/${user.id}"/>">修改信息</a></td>
                <td><a href="<c:url value="/manage/resetU/${user.id}"/>">重置密码</a></td>
                <td><a href="<c:url value="/manage/deleteU/${user.id}"/>">删除用户</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
每页${userList.pageSize}位用户， 第${userList.currentPageNo}/${userList.totalPageCount}页,共${paginationSupport.totalCount}位用户
<c:if test="${userList.previousPage}">
    <a href="<c:url value="/manage/managerList?pageNo=${userList.currentPageNo-1}" />">上一页</a>
</c:if>
<c:if test="${userList.nextPage}">
    <a href="<c:url value="/manage/managerList?pageNo=${userList.currentPageNo+1}" />">下一页</a>
</c:if>
<br><br><br>
</body>
<c:import url="footer.jsp"/>
</html>