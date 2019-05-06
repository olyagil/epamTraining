<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center fixed-top">

    <a class="navbar-brand" href="index.jsp">Косметический салон</a>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse"--%>
    <%--data-target="#collapsibleNavbar">--%>
    <%--<span class="navbar-toggler-icon"></span>--%>
    <%--</button>--%>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav ">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop"
                   data-toggle="dropdown">Услуги</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Для тела</a>
                    <a class="dropdown-item" href="#">Для лица</a>
                    <a class="dropdown-item" href="#">Для ног</a>
                    <a class="dropdown-item" href="#">Для руг</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Специалисты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="jsp/feedback.html">Отзызы</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navdroplang"
                   data-toggle="dropdown">Язык </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="">English</a>
                    <a class="dropdown-item" href="">Беларускі</a>
                    <a class="dropdown-item" href="">Русский</a>
                    <a class="dropdown-item" href="">Немецкий</a>
                </div>
            </li>
            <li class="nav-item" data-toggle="modal"
                data-target="#id01">
                <a class="nav-link">Modal</a>
            </li>

        </ul>
        <%--<form class="form-inline my-2 my-lg-0">--%>
        <%--<input class="form-control mr-sm-2" type="search"--%>
        <%--placeholder="Search" aria-label="Search">--%>
        <%--<button class="btn btn-outline-info my-2 my-sm-0" type="submit">--%>
        <%--Search--%>
        <%--</button>--%>
        <%--</form>--%>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${authorizedUser==null}">
                <li class="nav-item">
                    <a class="nav-link" href="jsp/signup.jsp">Регистрация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="jsp/login.jsp"><span
                            class="glyphicon glyphicon-log-in"></span> Вход</a>
                </li>
            </c:if>
            <c:if test="${authorizedUser!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="jsp/menu.jsp">Личный кабинет</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
<!-- Модальное окно -->
<!-- Button to open the modal login form -->
<button onclick="document.getElementById('id01').style.display='block'">Login
</button>

<!-- The Modal -->
<div id="id01" class="modal">
    <span onclick="document.getElementById('id01').style.display='none'"
          class="close" title="Close Modal">&times;</span>

    <!-- Modal Content -->
    <form class="modal-content animate" action="/action_page.php">
        <div class="imgcontainer">
            <img src="img_avatar2.png" alt="Avatar" class="avatar">
        </div>

        <div class="container">
            <label for="uname"><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname"
                   required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw"
                   required>

            <button type="submit">Login</button>
            <%--<label>--%>
            <%--<input type="checkbox" checked="checked" name="remember">--%>
            <%--Remember me--%>
            <%--</label>--%>
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button"
                    onclick="document.getElementById('id01').style.display='none'"
                    class="cancelbtn">Cancel
            </button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</div>


</body>
</html>
