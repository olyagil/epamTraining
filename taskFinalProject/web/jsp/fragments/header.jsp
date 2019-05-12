<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light ">
    <div class="container">
        <c:url value="/index.jsp" var="mainUrl"/>
        <a class="navbar-brand" href="${mainUrl}">Косметический салон</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <c:url value="/services.html" var="servicesUrl"/>
                    <a class="nav-link" href="${servicesUrl}">Услуги</a>
                </li>

                <li class="nav-item">
                    <c:url value="/specialists.html" var="specialistUrl"/>
                    <a class="nav-link" href="${specialistUrl}">Специалисты</a>
                </li>

                <li class="nav-item">
                    <c:url value="/feedback.html" var="feedbackUrl"/>
                    <a class="nav-link" href="${feedbackUrl}"> Отзызы</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#"
                       id="navbarDropdownLang" data-toggle="dropdown"> Язык
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Русский</a>
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Беларускі</a>
                        <a class="dropdown-item" href="#">Немецкі</a>
                    </div>
                </li>
                <c:if test="${id==null}">
                <li class="nav-item">
                    <c:url value="jsp/signup.jsp" var="signupUrl"/>
                    <a class="nav-link" href="${signupUrl}">Регистрация </a>
                </li>
                <li class="nav-item">
                    <c:url value="jsp/login.jsp" var="loginUrl"/>
                    <a class="nav-link" href="${loginUrl}"> Вход </a>
                </li>
                </c:if>
                <c:if test="${id!=null}">

                <li class="nav-item">
                    <c:url value="/account/main.html" var="mainUrl"/>
                    <a class="nav-link" href="${mainUrl}">Личный кабинет </a>
                </li>
                    <%--<li class="nav-item dropdown">--%>
                    <%--<a class="nav-link dropdown-toggle" href="${menuUrl}"--%>
                    <%--id="navbarDropdown" data-toggle="dropdown">Личный кабинет--%>
                    <%--</a>--%>
                    <%--<div class="dropdown-menu">--%>
                    <%--<c:forEach items="${menu}" var="item">--%>
                    <%--<a class="dropdown-item"--%>
                    <%--href="${item.url}">${item.name}</a>--%>
                    <%--</c:forEach>--%>
                    <%--<c:url value="/jsp/account/edit.jsp"--%>
                    <%--var="accountEditUrl"/>--%>
                    <%--<div class="dropdown-divider"></div>--%>
                    <%--<a class="dropdown-item"--%>
                    <%--href="${accountEditUrl}">Редактирование профиля</a>--%>
                    <%--<c:url value="/logout.html" var="logoutUrl"/>--%>
                    <%--<a class="dropdown-item" href="${logoutUrl}">Выход</a>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                </c:if>
        </div>
    </div>
</nav>
</body>
</html>
