<%@page language="java" contentType="text/html;charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<br>
<br>
<br>
<div class="row justify-content-md-center">
    <div class="col-sm-6">
        <!-- Default form login -->
        <c:url value="/login.html" var="loginUrl"/>

        <form class="border border-light p-5 needs-validation"
              action="${loginUrl}" method="post" novalidate>
            <p class="h4 mb-4 text-center">Login</p>

            <!-- Login -->
            <div class="form-group ">
                <label for="login">Имя пользователя:</label>
                <input type="text" class="form-control mb-4" id="login"
                       placeholder="Введите имя пользователя" name="login"
                       required>
                <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
            </div>

            <!-- Password -->
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control mb-4" id="password"
                       placeholder="Введите пароль" name="password" required>
                <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
            </div>

            <!-- Sign in button -->
            <button class="btn btn-info btn-block my-4" type="submit">Войти
            </button>

            <!-- Register -->
            <c:url value="signup.jsp" var="signupUrl"/>
            <p class="text-center">Not a member? <a href="${signupUrl}">
                Зарегестрироваться</a>
            </p>
        </form>
    </div>
</div>


<jsp:include page="fragments/footer.jsp"/>

</body>
</html>
