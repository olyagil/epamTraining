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
        <a class="nav-link" href="${accountMainUrl}">Главная</a>
        <c:url value="/client/list.html" var="clientListUrl"/>
        <c:url value="/employee/list.html" var="employeeListUrl"/>
        <c:url value="/service/list.html" var="serviceListUrl"/>
        <c:url value="/talon/list.html" var="talonListUrl"/>
        <c:url value="/feedback/list.html" var="feedbackListUrl"/>   <c:choose>


            <c:when test="${sessionScope.role eq 0}">
                <a class="nav-link" href="${clientListUrl}"> Список клиентов
                </a>

                <a class="nav-link" href="${employeeListUrl}"> Список
                    сотрудников</a>

                <a class="nav-link" href="${serviceListUrl}"> Список услуг </a>

                <a class="nav-link" href="${talonListUrl}"> Талоны </a>

                <a class="nav-link" href="${feedbackListUrl}"> Отзывы </a>
            </c:when>

            <c:when test="${sessionScope.role eq 1}">
                <a class="nav-link" href="${feedbackListUrl}"> Отзывы </a>
                <a class="nav-link" href="${talonListUrl}"> Мои талоны </a>
            </c:when>

            <c:when test="${sessionScope.role eq 2}">
                <a class="nav-link" href="${feedbackListUrl}"> Отзывы </a>
                <a class="nav-link" href="${talonListUrl}"> Мои талоны </a>
            </c:when>

        </c:choose>

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="${accountEditUrl}"
               id="navbarDropdown" data-toggle="dropdown"> Редактирование
                профиля </a>
            <div class="dropdown-menu">

                <a class="dropdown-item"
                   href="${accountEditInfoUrl}"> Редактрование информации </a>

                <a class="dropdown-item"
                   href="${accountEditPasswordUrl}"> Изменить пароль </a>
            </div>
        </li>

        <a class="nav-link" href="${logoutUrl}"> Выход </a>
    </nav>
</div>
<br>
</body>
</html>
