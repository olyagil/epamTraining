<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
    <link rel="stylesheet" href="../css/signup.css" type="text/css">
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<c:url value="/signup.html" var="signupUrl"/>
<form action="${signupUrl}" style="border:1px solid #ccc">
    <div class="container">
        <h1>Sign Up Регистрация</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="login"><b>*Логин</b></label>
        <input type="text" placeholder="Enter Email" name="login" required>

        <label for="password"><b>*Password</b></label>
        <input type="password" placeholder="Enter Password" name="password"
               required>

        <label for="password-repeat"><b>*Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password"
               name="password-repeat" required>

        <label for="name"><b>*Name</b></label>
        <input type="text" placeholder="Введите имя" name="name" required>

        <label for="surname"><b>*Surname</b></label>
        <input type="text" placeholder="Введите фамилию" name="surname"
               required>
        <label for="patronymic"><b>*Patronymic</b></label>
        <input type="text" placeholder="Введите отчество" name="patronymic"
               required>

        <label for="phone"><b>*Phone</b></label>
        <input type="text" placeholder="Введите мобильный телефон" name="phone"
               id="phone" required>
        <input type="text" class="input-medium bfh-phone"
               data-format="+375 (dd) ddd-dd-dd">
        <label for="birthdate"><b>*Date of Birth</b></label>
        <input type="date" placeholder="Выберите день рождения"
               name="birthdate" required>
        <label for="photo"><b>*Выберите фото</b></label>
        <input type="file" placeholder="Выберите фото" name="photo"
               accept="image/png">

        <div class="clearfix">
            <%--<button type="button" class="cancelbtn">Cancel</button>--%>
            <button type="submit" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>

<%@include file="fragments/footer.jsp" %>
</body>

<script>
    //Код jQuery, установливающий маску для ввода телефона элементу input
    //1. После загрузки страницы,  когда все элементы будут доступны выполнить...
    $(function () {
        //2. Получить элемент, к которому необходимо добавить маску
        $("#phone").mask("+375(99) 999-9999");
    });
</script>

</html>
