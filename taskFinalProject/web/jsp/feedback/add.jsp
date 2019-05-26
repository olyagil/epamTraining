<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Добавление отзыва</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${talonListUrl}">Талоны</a></li>
        <li class="breadcrumb-item active">Добавление отзыва</li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2>Добавление отзыва</h2></div>
    </div>

    <div class="row">

        <div class="col-md-9">
            <c:url value="/feedback/save.html" var="feedbackSaveUrl"/>
            <form action="${feedbackSaveUrl}" class="row" method="post">
                <div class="col-md-5">
                    <br>
                    <p><b>Процедура: </b><c:out
                            value="${requestScope.talon.service.name}"/>
                        <br><br> <b>Специалист: </b>
                        <c:out value="${requestScope.talon.employee.surname}
                        ${requestScope.talon.employee.name}"/>
                        <br><br><b>Дата приема: </b>
                        <c:out value="${requestScope.talon.receptionDate}"/>
                    </p>
                </div>

                <div class="col-md-7">
                    <div class="form-group">
                        <label for="review">Отзыв </label>
                        <textarea class="form-control" rows="8" cols="7"
                                  id="review"
                                  placeholder="Введите ваш отзыв здесь..."
                                  name="review" required></textarea>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col">
                                <input type="hidden" name="employeeId"
                                       value="${requestScope.talon.employee.id}">
                                <button class="btn btn-lg btn-success"
                                        type="submit"> Save
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>