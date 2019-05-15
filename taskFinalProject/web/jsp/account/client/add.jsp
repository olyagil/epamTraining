<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
<body>
<jsp:include page="../../fragments/header.jsp"/>
<jsp:include page="../../fragments/sidebar.jsp"/>

<div class="container">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <h1>Добавление нового пользователя</h1>
                <p>Заполните форму, что добавить пользователя.</p>
            </div>
            <div class="card-body">
                <c:url value="/account/" var="signupUrl"/>
                <form action="${signupUrl}" method="post">
                    <div class="form-group row">
                        <label for="login"
                               class="col-md-4 col-form-label text-md-right">
                            <b><font color="red">* </font>Логин</b> </label>
                        <div class="col-md-6">
                            <input type="text" id="login"
                                   placeholder="Enter Login"
                                   class="form-control" name="login" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="password"
                               class="col-md-4 col-form-label text-md-right">
                            <b>*Password</b></label>
                        <div class="col-md-6">
                            <input type="password" id="password"
                                   placeholder="Enter password"
                                   class="form-control" name="password"
                                   required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="password-repeat"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Repeat password </b></label>
                        <div class="col-md-6">
                            <input type="password" id="password-repeat"
                                   placeholder="Enter password"
                                   class="form-control" name="password-repeat"
                                   required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="name"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Name </b></label>
                        <div class="col-md-6">
                            <input type="text" id="name"
                                   placeholder="Enter name"
                                   class="form-control" name="name" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="surname"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Surname </b></label>
                        <div class="col-md-6">
                            <input type="text" id="surname"
                                   placeholder="Enter surname"
                                   class="form-control" name="surname" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="patronymic"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Patronymic </b></label>
                        <div class="col-md-6">
                            <input type="text" id="patronymic"
                                   placeholder="Enter patronymic"
                                   class="form-control" name="patronymic"
                                   required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="genderF"
                               class="radio-inline col-md-6 col-form-label text-md-right">
                            <input type="radio" name="gender" id="genderF">
                            <b>Женщина </b>
                        </label>
                        <label for="genderM"
                               class="radio-inline col-md-2 col-form-label text-md-right">
                            <input type="radio" id="genderM"
                                   name="gender"><b>Мужчина</b></label>
                    </div>
                    <div class="form-group row">
                        <label for="phone"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Phone </b></label>
                        <div class="col-md-6">
                            <input type="text" id="phone"
                                   placeholder="Enter phone"
                                   class="form-control" name="phone" required>
                            <%--<input type="text" class="input-medium bfh-phone"--%>
                            <%--data-format="+375(dd)ddd-dd-dd">--%>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="birthdate"
                               class="col-md-4 col-form-label text-md-right">
                            <b>* Date of birth </b></label>
                        <div class="col-md-6">
                            <input type="date" id="birthdate"
                                   placeholder="Enter date of birth "
                                   class="form-control" name="birthdate"
                                   required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="photo"
                               class="col-md-4 col-form-label text-md-right">
                            <b>Photo </b></label>
                        <div class="col-md-6">
                            <input type="file" id="photo"
                                   class="form-control" name="photo">
                        </div>
                    </div>

                    <div class="col-md-6 offset-md-6">
                        <button type="submit" class="btn btn-lg btn-success">
                            Добавить
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="../../fragments/footer.jsp" %>

</body>


</html>
