<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование талона</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${talonListUrl}">Список
            талонов</a>
        </li>
        <li class="breadcrumb-item active">Редактирование талона</li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2>Редактирование талона</h2></div>

        <c:if test="${not empty requestScope.talon}">
            <c:url value="/talon/delete.html"
                   var="talonDeleteUrl"/>
            <form action="${talonDeleteUrl}" method="post">
                <input type="hidden" value="${requestScope.talon.id}" name="id">
                <button class="btn btn-lg btn-danger" type="submit" name="id"
                        value="${requestScope.talon.id}">Удалить
                </button>
            </form>
        </c:if>
    </div>
    <div class="col-md-6">

    <c:if test="${not empty sessionScope.failure_save_talon}">
        <div class="alert alert-success" role="alert">
                ${sessionScope.failure_save_talon}
            <c:remove var="failure_save_talon" scope="session"/>
        </div>
    </c:if></div>
    <br>

    <div class="col-md-9">
        <c:url value="/talon/save.html" var="talonSaveUrl"/>
        <form action="${talonSaveUrl}" method="get" class="row">
            <div class="col-md-6">
                <input type="hidden" value="${requestScope.talon.id}" name="id">
                <div class="form-group">
                    <label for="client-name"> Client name </label>
                    <input type="text" class="form-control"
                           name="client-name" id="client-name"
                           value="${requestScope.talon.client.surname}
                           ${requestScope.talon.client.name} "
                           disabled required>
                </div>
                <div class="form-group">
                    <label for="employee-name"> Employee name </label>
                    <input type="text" class="form-control"
                           name="employee-name" id="employee-name"
                           value="${requestScope.talon.employee.surname}
                           ${requestScope.talon.employee.name} "
                           disabled required>
                </div>
                <div class="form-group">
                    <label for="service"> Услуга </label>
                    <select class="form-control" id="service" name="serviceId">
                        <c:forEach items="${requestScope.services}" var="service">
                            <c:if test="${requestScope.talon.service.id eq service.id}">
                                <option selected value="${service.id}">
                                        ${service.name} </option>
                            </c:if>
                            <c:if test="${requestScope.talon.service.id ne service.id}">
                                <option value="${service.id}">
                                        ${service.name} </option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="receptionDate"> Reception date </label>
                    <input type="text" class="form-control"
                           name="receptionDate" id="receptionDate"
                           value="${requestScope.talon.receptionDate}"
                           placeholder="Выберите дату приема">
                </div>

                <div class="form-group">
                    <label for="status"> Статус </label>
                    <select class="form-control" id="status" name="status">
                        <c:if test="${requestScope.talon.status eq true}">
                            <option value="true" selected> Выполнен</option>
                            <option value="false"> Не выполнен</option>
                        </c:if>
                        <c:if test="${requestScope.talon.status eq false}">
                            <option value="true"> Выполнен</option>
                            <option value="false" selected> Не выполнен</option>
                        </c:if>
                    </select>
                </div>

                <div class="form-group">
                    <div class="col">
                        <br>
                        <input type="hidden" name="clientId"
                               value="${requestScope.talon.client.id}">
                        <input type="hidden" name="employeeId"
                               value="${requestScope.talon.employee.id}">
                        <button type="submit" class="btn btn-lg btn-primary">
                            Save changes
                        </button>
                        <button class="btn btn-lg" type="reset">
                            Reset
                        </button>
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>