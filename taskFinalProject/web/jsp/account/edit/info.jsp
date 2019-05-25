<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active"> Редактирование информации</li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2>Редактирование информации</h2></div>
    </div>
    <br>
    <br>
    <div class="row">
        <!--left col-->
        <c:url value="/account/save/avatar.html" var="saveImgUrl"/>
        <div class="col-md-3">
            <form action="${saveImgUrl}" method="post"
                  enctype="multipart/form-data">
                <div class="text-center">
                    <img src="data:image/png;base64,${user.avatar}"
                         class="avatar img-circle img-thumbnail img-responsive"
                         alt="avatar">
                    <h6>Upload a different photo...</h6>
                    <input type="file" name="img"
                           class="text-center center-block file-upload">
                    <button type="submit"
                            class="btn btn-primary btn-lg">Изменить
                    </button>
                </div>
                <hr>

            </form>
        </div>
        <hr>

        <div class="col-md-9">
            <c:url value="/account/save/info.html" var="accountEditUrl"/>
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

                    <c:if test="${not empty sessionScope.success_save_info}">
                        <div class="alert alert-success" role="alert">
                                ${sessionScope.success_save_info}
                            <c:remove var="success_save_info" scope="session"/>
                        </div>
                    </c:if>
                    <c:if test="${not empty sessionScope.failure_save_info}">
                        <div class="alert alert-success" role="alert">
                                ${sessionScope.failure_save_info}
                            <c:remove var="failure_save_info" scope="session"/>
                        </div>
                    </c:if>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="login"> Login </label>
                        <input type="text" class="form-control" name="login"
                               id="login" value="${user.login}"
                               placeholder="Введите логин">
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

                    <div class="row">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <div class="form-group ">
                            <div class="col">
                                <br>
                                <button class="btn btn-lg btn-primary"
                                        type="submit"> Save
                                </button>
                                <button class="btn btn-lg" type="reset">
                                    Reset
                                </button>
                            </div>
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