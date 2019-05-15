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
        <c:url value="/account/main.html" var="accountMainUrl"/>
        <a class="nav-link" href="${accountMainUrl}">Главная</a>
        <c:forEach items="${menu}" var="item">
            <c:url value="${item.url}" var="url"/>
            <a class="nav-link" href="${url}">
                    ${item.name} </a>
        </c:forEach>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="${accountEditUrl}"
               id="navbarDropdown" data-toggle="dropdown">Редактирование
                профиля </a>
            <div class="dropdown-menu">
                <c:url value="/account/edit/info.html"
                       var="accountEditInfoURL"/>
                <a class="dropdown-item"
                   href="${accountEditInfoURL}">Редактрование информации </a>
                <c:url value="/account/edit/password.html"
                       var="accountEditPasswordURL"/>
                <a class="dropdown-item"
                   href="${accountEditPasswordURL}">Изменить пароль </a>
            </div>
        </li>
        <c:url value="/logout.html" var="logoutUrl"/>
        <a class="nav-link" href="${logoutUrl}"> Выход </a>
    </nav>
</div>
<br><br>
</body>
</html>
