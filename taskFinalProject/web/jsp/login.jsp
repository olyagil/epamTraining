<%@page language="java" contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<%--<%@include file="fragments/header.jsp" %>--%>
<div class="container">

    <h1>Вход в систему</h1>
    <c:url value="/login.html" var="loginUrl"/>

    <form action="${loginUrl}" class="needs-validation" novalidate
          method="post">

        <div class="form-group">
            <label for="login">Имя пользователя:</label>
            <input type="text" class="form-control" id="login"
                   placeholder="Введите имя пользователя" name="login"
                   value="${param.login}" required>
            <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" class="form-control" id="password"
                   placeholder="Введите пароль" name="password" required>
            <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
        </div>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
</div>


</body>
<jsp:include page="fragments/footer.jsp"/>



