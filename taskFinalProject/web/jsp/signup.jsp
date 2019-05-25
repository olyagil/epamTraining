<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
<body>
<jsp:include page="fragments/header.jsp"/>
<br><br>
<div class="container">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <h1>Sign Up Регистрация</h1>
                <p>Please fill in this form to create an account.</p>
            </div>
            <div class="card-body">
                <c:url value="/signup.html" var="signupUrl"/>
                <form action="${signupUrl}" method="post"
                      enctype="multipart/form-data">
                    <c:if test="${not empty sessionScope.message_signup}">
                        <div class="alert alert-danger" role="alert">
                                ${sessionScope.message_signup}
                            <c:remove var="message_signup"
                                      scope="session"/>
                        </div>
                    </c:if>
                    <div class="form-group row">

                        <label for="login"
                               class="col-md-4 col-form-label text-md-right">
                            *Логин </label>
                        <div class="col-md-6">
                            <input type="text" id="login"
                                   placeholder="Enter Login"
                                   class="form-control" name="login" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="password"
                               class="col-md-4 col-form-label text-md-right">*Password</label>
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
                            * Repeat password</label>
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
                            * Name </label>
                        <div class="col-md-6">
                            <input type="text" id="name"
                                   placeholder="Enter name"
                                   class="form-control" name="name" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="surname"
                               class="col-md-4 col-form-label text-md-right">
                            * Surname </label>
                        <div class="col-md-6">
                            <input type="text" id="surname"
                                   placeholder="Enter surname"
                                   class="form-control" name="surname" required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="patronymic"
                               class="col-md-4 col-form-label text-md-right">
                            * Patronymic </label>
                        <div class="col-md-6">
                            <input type="text" id="patronymic"
                                   placeholder="Enter patronymic"
                                   class="form-control" name="patronymic"
                                   required>
                        </div>
                    </div>
                    <div class="form-group ">
                        <div class="maxl">
                            <label class="radio inline col-md-6 col-form-label text-md-right">
                                <input type="radio" name="gender"
                                       value="male" checked>
                                <span> Male </span>
                            </label>
                            <label class="radio inline col-md-2 col-form-label text-md-right">
                                <input type="radio" name="gender"
                                       value="female">
                                <span>Female </span>
                            </label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="phone"
                               class="col-md-4 col-form-label text-md-right">
                            * Phone </label>
                        <div class="col-md-6">
                            <input type="text" id="phone"
                                   placeholder="Enter phone"
                                   class="form-control" name="phone" required>
                            <%--<input type="text" class="input-medium bfh-phone"--%>
                            <%--data-format="+375(dd)ddd-dd-dd">--%>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="birth_date"
                               class="col-md-4 col-form-label text-md-right">
                            * Date of birth </label>
                        <div class="col-md-6">
                            <input type="date" id="birth_date"
                                   placeholder="Enter date of birth "
                                   class="form-control" name="birth_date"
                                   required>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="img"
                               class="col-md-4 col-form-label text-md-right">
                            Photo </label>
                        <div class="col-md-6">
                            <input type="file" id="img"
                                   class="form-control" name="img">
                        </div>
                    </div>

                    <div class="col-md-6 offset-md-6">
                        <button type="submit" class="btn btn-lg btn-primary">
                            Sign Up
                        </button>
                    </div>
                    <br>
                    <div class="form-group">
                        <p class="text-center">Already have an account?
                            <c:url value="login.jsp" var="loginUrl"/>
                            <a href="${loginUrl}">Log in here</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="fragments/footer.jsp" %>
</body>
</html>
