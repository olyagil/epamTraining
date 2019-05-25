<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Измениние пароля</title>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/js/validator-of-change-password-form.js"></script>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Измениние пароля</li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2>Измениние пароля</h2></div>
    </div>

    <div class="row">

        <div class="col-md-9">
            <c:url value="/account/save/password.html" var="accountEditUrl"/>
            <form action="${accountEditUrl}" class="row" method="post"
                  onsubmit="return validateChangePassword(this)">
                <div class="col-md-6">

                </div>

                <div class="col-md-6">

                    <div class="form-group">
                        <label for="old-password"> Old Password </label>
                        <input type="password" class="form-control"
                               name="old-password" id="old-password"
                               placeholder="Введите старый пароль" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Password </label>
                        <input type="password" class="form-control"
                               name="password" id="password"
                               placeholder="Введите пароль" required>
                    </div>

                    <%--<div class="form-group">--%>
                        <%--<label for="password-repeat">Repeat password </label>--%>
                        <%--<input type="password" class="form-control"--%>
                               <%--name="password-repeat"--%>
                               <%--id="password-repeat"--%>
                               <%--placeholder="Повторите пароль" required>--%>
                    <%--</div>--%>
                    <c:if test="${not empty sessionScope.success_save_password}">
                        <div class="alert alert-success" role="alert">
                                ${sessionScope.success_save_password}
                            <c:remove var="success_save_password" scope="session"/>
                        </div>
                    </c:if>
                    <c:if test="${not empty sessionScope.message}">
                        <div class="alert alert-danger" role="alert">
                                ${sessionScope.message}
                            <c:remove var="message" scope="session"/>
                        </div>
                    </c:if>
                    <c:if test="${not empty sessionScope.failure_save_password}">
                        <div class="alert alert-danger" role="alert">
                                ${sessionScope.failure_save_password}
                            <c:remove var="failure_save_password" scope="session"/>
                        </div>
                    </c:if>


                    <div class="row">
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