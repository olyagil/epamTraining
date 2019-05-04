<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a class="nav-link" href="jsp/feedback.jsp">Отзызы</a>
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
                data-target="#exampleModal">
                <a class="nav-link">Modal</a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
                <a class="nav-link" href="jsp/signup.jsp">Регистрация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="jsp/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Вход</a>
            </li>

        </ul>
    </div>
</nav>
<!-- Модальное окно -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Заголовок
                    модального окна</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Содержимое модального окна
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info">Любая кнопка</button>
                <button type="button" class="btn btn-secondary"
                        data-dismiss="modal">Закрыть
                </button>
            </div>
        </div>
    </div>
</div>


</body>
</html>
