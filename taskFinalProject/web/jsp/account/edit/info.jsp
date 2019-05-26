<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Реааьивпола</title>
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
                    <img src="data:image/png;base64,${requestScope.user.avatar}"
                         class="avatar img-circle img-thumbnail img-responsive"
                         alt="avatar">
                    <h6>Upload a different photo...</h6>
                    <input type="file" name="img"
                           class="text-center center-block file-upload"
                           required>
                    <button type="submit"
                            class="btn btn-success float-right">Изменить
                    </button>
                </div>

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
                               value="${requestScope.user.surname}"
                               placeholder="Введите фамилию"
                               pattern="[a-zA-Zа-яА-Я0-9-]{2,30}" required>
                    </div>

                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name"
                               id="name" value="${requestScope.user.name}"
                               placeholder="Введите имя"
                               pattern="[a-zA-Zа-яА-Я0-9]{2,30}" required>
                    </div>

                    <div class="form-group">
                        <label for="patronymic">Patronymic </label>
                        <input type="text" class="form-control"
                               name="patronymic" id="patronymic"
                               value="${requestScope.user.patronymic}"
                               placeholder="Введите отчество"
                               pattern="[a-zA-Zа-яА-Я0-9]{2,30}" required>
                    </div>
                    <div class="form-group">
                        <div class="maxl">
                            <c:if test="${requestScope.user.gender.id eq 0}">
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
                            <c:if test="${requestScope.user.gender.id eq 1}">
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
                               id="login" value="${requestScope.user.login}"
                               placeholder="Введите логин"
                               pattern="[a-zA-Zа-яА-Я0-9]{2,30}" required>
                    </div>

                    <div class="form-group">
                        <label for="phone"> Phone (9 цифр) </label>
                        <input type="text" class="form-control"
                               name="phone" id="phone"
                               value="${requestScope.user.phone}"
                               placeholder="Введите телефон"
                               pattern="[0-9]{9}" required>
                    </div>

                    <div class="form-group">
                        <label for="birth_date"> Date of birth </label>
                        <input type="date" class="form-control"
                               name="birth_date" id="birth_date"
                               value="${requestScope.user.birthDate}"
                               placeholder="Введите дату рождения" required>
                    </div>

                    <div class="row">
                        <input type="hidden" name="id"
                               value="${requestScope.user.id}"/>
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

                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>