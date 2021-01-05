<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户主页</title>
</head>
<c:import url="banner.jsp"/>
<body>

    <br><br>

    <div>
    <a href="<c:url value="/user/logout"/>">退出登录</a>
    </div>
    <br><br><br><br>

    <div>
    <a href="<c:url value="/user/info"/>">个人信息页面</a>
    </div>
    <br><br><br><br>

    <div>
    <a href="<c:url value="/user/questionnaire/create/${sessionScope.user.id}"/>">发布新问卷</a>
    </div>
    <br><br><br><br>

    <div>
    <a href="<c:url value="/user/questionnaire/questionnaireList"/>">查看已发布的问卷列表</a>
    </div>
    <br><br><br><br>

    </body>
    <c:import url="footer.jsp"/>
    </html>
