<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
    <link href="../css/sidebar.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<%@include file="fragments/header.jsp" %>
<br>
<br>
<c:if test="${not empty authorizedUser}">
    <div class="sidebar">
        <a class="active" href="#home">Главная</a>
        <c:forEach items="${menu}" var="item">
            <c:url value="${item.url}" var="itemUrl"/>
            <a href="${itemUrl}">${item.name}</a>
        </c:forEach>

        <c:url value="profile/edit.html" var="profileEditUrl"/>
        <a href="${profileEditUrl}">Редактирование профиля</a>

        <c:url value="/logout.html" var="logoutUrl"/>
        <a href="${logoutUrl}">Выход</a>
    </div>

    <div class="content">
        <br>
        <h3>Добро пожаловать, ${authorizedUser.login}</h3>
        <hr>

    </div>
</c:if>
</body>
</html>
