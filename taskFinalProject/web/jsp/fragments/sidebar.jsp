<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Menu</title>
</head>
<body>

<div class="nav-scroller bg-white shadow-sm">
    <nav class="nav nav-underline">
        <c:url value="main.jsp" var="accountMainUrl"/>
        <a class="nav-link" href="${accountMainUrl}"> Главная </a>
        <c:forEach items="${menu}" var="item">
            <a class="nav-link" href="${item.url}"> ${item.name} </a>
        </c:forEach>
        <c:url value="edit.jsp" var="accountEditUrl"/>
        <a class="nav-link" href="${accountEditUrl}"> Редактирование
            профиля </a>
        <c:url value="/logout.html" var="logoutUrl"/>
        <a class="nav-link" href="${logoutUrl}"> Выход </a>
    </nav>
</div>
</body>
</html>
