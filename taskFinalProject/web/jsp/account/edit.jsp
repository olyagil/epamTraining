<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/sidebar.jsp" %>

<div class="col-sm-15"><!--left col-->
    <div class="text-center">
        <img src="img/man_avatar.png"
             class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Upload a different photo...</h6>
        <input type="file" class="text-center center-block file-upload">
    </div>
    <hr>
    <br>
</div>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="tab-content">
        <div class="tab-pane active" id="home">
            <hr>
            <c:url value="/account/edit.html" var="accountEditUrl"/>
            <form class="form" action="${accountEditUrl}" method="post"
                  id="editForm">
                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="name"><h4>Name</h4></label>
                        <input type="text" class="form-control"
                               name="name" id="name" value="${user.name}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="login"><h4>Login</h4></label>
                        <input type="text" class="form-control"
                               name="login" id="login" value="${user.login}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="surname"><h4>Surname</h4></label>
                        <input type="text" class="form-control"
                               name="surname" id="surname"
                               value="${user.surname}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="password"><h4>Password</h4></label>
                        <input type="password" class="form-control"
                               name="password" id="password"
                               placeholder="Введите новый пароль">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="patronymic"><h4>Patronymic</h4>
                        </label>
                        <input type="text" class="form-control"
                               name="patronymic" id="patronymic"
                               value="${user.patronymic}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="password-repeat"><h4>Password</h4>
                        </label>
                        <input type="password" class="form-control"
                               name="password-repeat" id="password-repeat"
                               placeholder="Повторите пароль">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="phone"><h4>Phone</h4></label>
                        <input type="text" class="form-control"
                               name="phone" id="phone" value="${user.phone}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <label for="birth_date"><h4>Date of birth</h4></label>
                        <input type="date" class="form-control"
                               name="birth_date" id="birth_date"
                               value="${user.birthDate}">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <br>
                        <button class="btn btn-lg btn-success"
                                type="submit"> Save
                        </button>
                        <button class="btn btn-lg" type="reset"> Reset
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>