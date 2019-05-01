<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<head>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet"--%>
    <%--href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>
</head>
<body>
<div class="container">
    <u:html title="Вход в систему" message="${message}">
        <h2>Вход в систему</h2>
        <c:url value="client/list.jsp" var="loginUrl"/>
        <form action="${loginUrl}" class="needs-validation" novalidate
              method="post">
            <div class="form-group">
                <label for="login">Имя пользователя:</label>
                <input type="text" class="form-control" id="login"
                       placeholder="Введите имя пользователя" name="login"
                       value="${param.login}" required>
                    <%--<div class="valid-feedback">Верно</div>--%>
                <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control" id="password"
                       placeholder="Введите пароль" name="password" required>
                    <%--<div class="valid-feedback">Верно</div>--%>
                <div class="invalid-feedback">Пожалуйста, заполните поле!</div>
            </div>
            <div class="form-group form-check">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox"
                           name="remember">Запомнить меня</label>
            </div>

            <button type="submit" class="btn btn-primary">Войти</button>
        </form>
    </u:html>
</div>

<script>
    // Disable form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
// Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
// Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>

</body>


