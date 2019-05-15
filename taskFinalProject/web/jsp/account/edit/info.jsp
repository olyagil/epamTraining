<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/sidebar.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Photos</a></li>
        <li class="breadcrumb-item"><a href="#">Summer 2017</a></li>
        <li class="breadcrumb-item"><a href="#">Italy</a></li>
        <li class="breadcrumb-item active">Rome</li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2>Редактирование профиля</h2></div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-md-3"><!--left col-->
            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                     class="avatar img-circle img-thumbnail img-responsive"
                     alt="avatar">
                <h6>Upload a different photo...</h6>
                <input type="file" class="text-center center-block file-upload">
            </div>
            <hr>
        </div>
        <hr>

        <div class="col-md-9">
            <c:url value="/account/user/save.html" var="accountEditUrl"/>
            <form action="${accountEditUrl}" class="row">
                <div class="col-md-6">

                    <div class="form-group">
                        <label for="surname"> Surname </label>
                        <input type="text" class="form-control"
                               name="surname" id="surname"
                               value="${user.surname}"
                               placeholder="Введите фамилию">
                    </div>

                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name"
                               id="name" value="${user.name}"
                               placeholder="Введите имя">
                    </div>

                    <div class="form-group">
                        <label for="patronymic">Patronymic </label>
                        <input type="text" class="form-control"
                               name="patronymic" id="patronymic"
                               value="${user.patronymic}"
                               placeholder="Введите отчество">
                    </div>


                    <div class="form-group">
                        <label for="phone"> Phone </label>
                        <input type="text" class="form-control"
                               name="phone" id="phone" value="${user.phone}"
                               placeholder="Введите телефон">
                    </div>

                    <div class="form-group">
                        <label for="birth_date"> Date of birth </label>
                        <input type="date" class="form-control"
                               name="birth_date" id="birth_date"
                               value="${user.birthDate}"
                               placeholder="Введите дату рождения">
                    </div>

                    <div class="form-group">
                        <div class="maxl">
                            <c:if test="${user.gender.id eq 0}">
                                <label class="radio inline">
                                    <input type="radio" name="gender"
                                           value="male">
                                    <span> Male </span>
                                </label>
                                <label class="radio inline">
                                    <input type="radio" name="gender"
                                           value="female" checked>
                                    <span>Female </span>
                                </label>
                            </c:if>
                            <c:if test="${user.gender.id eq 1}">
                                <label class="radio inline">
                                    <input type="radio" name="gender"
                                           value="male" checked>
                                    <span> Male </span>
                                </label>
                                <label class="radio inline">
                                    <input type="radio" name="gender"
                                           value="female">
                                    <span>Female </span>
                                </label>
                            </c:if>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">

                    <div class="form-group">
                        <label for="login"> Login </label>
                        <input type="text" class="form-control" name="login"
                               id="login" value="${user.login}"
                               placeholder="Введите логин">
                    </div>

                    <div class="form-group">
                        <label for="password"> Password </label>
                        <input type="password" class="form-control"
                               name="password" id="password"
                               placeholder="Введите новый пароль">
                    </div>

                    <div class="form-group">
                        <label for="password-repeat">Repeat password </label>
                        <input type="password" class="form-control"
                               name="password-repeat"
                               id="password-repeat"
                               placeholder="Повторите пароль">
                    </div>

                    <div class="form-group">
                        <label for="role"> Role </label>
                        <select class="form-control" id="role" name="role">
                            <option disabled selected>${user.role.name}</option>

                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group ">
                        <div class="col">
                            <br>
                            <button class="btn btn-lg btn-success"
                                    type="submit"> Save
                            </button>
                            <button class="btn btn-lg" type="reset">
                                Reset
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>