<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link
            rel="stylesheet"
            href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<body>

<%@include file="fragments/header.jsp" %>
<%@include file="fragments/sidebar.jsp" %>

<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-12"><h1>${user.login}</h1></div>

    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->
            <div class="text-center">
                <img src="img/man_avatar.png"
                     class="avatar img-circle img-thumbnail" alt="avatar">
                <h6>Upload a different photo...</h6>
                <input type="file" class="text-center center-block file-upload">
            </div>
            <hr>
            <br>
        </div>
        <!--/col-3-->
        <div class="col-sm-9">

            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="active">
                    <a data-toggle="tab" href="#home">Home</a>
                </li>

                <c:forEach items="${menu}" var="item">

                    <li><a data-toggle="tab" href="#${item.url}">${item.name}
                            ${item.url}</a>
                    </li>
                </c:forEach>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>
                    <c:url value="/account/edit.html" var="accountEditUrl"/>
                    <form class="form" action="${accountEditUrl}" method="post"
                          id="signupForm">
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="name"><h4>Name</h4>
                                </label>
                                <input type="text" class="form-control"
                                       name="name" id="name"
                                       placeholder="Введите имя">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="login"><h4>Login</h4>
                                </label>
                                <input type="text" class="form-control"
                                       name="login" id="login"
                                       placeholder="Введите логин">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="surname"><h4>Surname</h4>
                                </label>
                                <input type="text" class="form-control"
                                       name="surname" id="surname"
                                       placeholder="Введите фамилию">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password"><h4>Password</h4>
                                </label>
                                <input type="password" class="form-control"
                                       name="password" id="password"
                                       placeholder="Введите новый пароль"
                                       title="enter your password.">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-xs-6">
                                <label for="patronymic"><h4>Patronymic</h4>
                                </label>
                                <input type="text" class="form-control"
                                       name="patronymic" id="patronymic"
                                       placeholder="Введите отчество">
                            </div>
                        </div>

                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="password-repeat"><h4>Password</h4>
                                </label>
                                <input type="password" class="form-control"
                                       name="password-repeat"
                                       id="password-repeat"
                                       placeholder="Повторите пароль">
                            </div>
                        </div>
                        <div class="form-group">

                            <div class="col-xs-6">
                                <label for="phone"><h4>Phone</h4></label>
                                <input type="text" class="form-control"
                                       name="phone" id="phone"
                                       placeholder="Введите телефон">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-6">
                                <label
                                        for="birth_date"><h4>Date of
                                    birth</h4></label>
                                <input type="date" class="form-control"
                                       name="birth_date" id="birth_date"
                                       placeholder="Введите день рождения">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-12">
                                <br>
                                <button class="btn btn-lg btn-success"
                                        type="submit"><i
                                        class="glyphicon glyphicon-ok-sign"></i>
                                    Save
                                </button>
                                <button class="btn btn-lg" type="reset"><i
                                        class="glyphicon glyphicon-repeat"></i>
                                    Reset
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <%--<hr>--%>

                <div class="tab-pane" id="clientlist">
                    <hr>
                    <form class="form" action="" method="post"
                          id="clientListForm">

                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Фамилия</th>
                                    <th>Имя</th>
                                    <th>Отчество</th>
                                    <th>Пол</th>
                                    <th>Телефон</th>
                                    <th>Дата рожждения</th>
                                    <th>Фото</th>
                                </tr>
                                </thead>
                                <c:url value="/client/list.html"
                                       var="clientListUrl"/>
                                <c:forEach items="${clients}" var="client">
                                    <tr>
                                        <td><c:out
                                                value="${client.login}"/></td>
                                    </tr>


                                </c:forEach>
                            </table>
                        </div>
                    </form>
                </div>

            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div><!--/col-9-->
</div><!--/row-->

<%--<c:if test="${not empty user}">--%>
<%--<div class="sidebar">--%>
<%--<a class="active" href="menu.jsp">Главная</a>--%>
<%--<c:forEach items="${menu}" var="item">--%>
<%--<c:url value="/menu${item.url}"--%>
<%--var="itemUrl"/>--%>
<%--<a href="${itemUrl}">${item.name}</a>--%>
<%--</c:forEach>--%>

<%--<c:url value="/jsp/account/info.jsp"--%>
<%--var="accountEditUrl"/>--%>
<%--<a href="${accountEditUrl}">Редактирование профиля</a>--%>

<%--<c:url value="/logout.html" var="logoutUrl"/>--%>
<%--<a href="${logoutUrl}">Выход</a>--%>
<%--</div>--%>

<%--<div class="content">--%>
<%--<br>--%>
<%--<h3>Добро пожаловать, ${authorizedUser.login}</h3>--%>
<%--<hr>--%>
<%--<c:url value="account/edit.html" var="accountEditUrl"/>--%>
<%--<form action="${accountEditUrl}" method="post">--%>

<%--<button type="submit">Редактировать</button>--%>
<%--</form>--%>
<%--&lt;%&ndash;<c:import url="${item.url}"/>&ndash;%&gt;--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<%@include file="fragments/footer.jsp" %>--%>
</body>
</html>
