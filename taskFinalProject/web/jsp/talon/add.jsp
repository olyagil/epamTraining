<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Service list</title>
</head>

<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${talonListUrl}"> Список
            талонов</a></li>
        <li class="breadcrumb-item active">Добавление талона</li>
    </ul>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="modal-body">
            <c:url value="/talon/save.html" var="talonSave"/>
            <form action="${talonSave}" method="get">
                <div class="form-group">
                    <label for="service"> Выберите услугу </label>
                    <select class="form-control selectpicker"
                            id="service"
                            name="serviceId" data-live-search="true">
                        <c:forEach items="${requestScope.services}"
                                   var="service">
                            <option value="${service.id}">
                                <c:out value="${service.name}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="employee"> Выберите специалиста</label>
                    <c:choose>
                        <c:when test="${sessionScope.role eq 1}">
                            <select class="form-control" id="employee"
                                    name="employeeId">
                                <option selected
                                        value="${requestScope.employees.id}">
                                        ${requestScope.employees.surname}
                                        ${requestScope.employees.name}
                                </option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select class="form-control selectpicker"
                                    data-live-search="true" id="employee"
                                    name="employeeId">
                                <c:forEach items="${requestScope.employees}"
                                           var="employee">
                                    <option value="${employee.id}">
                                            ${employee.surname} ${employee.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="form-group">
                    <label for="clients"> Выберите клиента</label>
                    <select class="form-control selectpicker"
                            data-live-search="true" id="clients"
                            name="clientId">
                        <c:forEach items="${requestScope.clients}" var="client">
                            <option value="${client.id}">
                                    ${client.surname} ${client.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="receptionDateCol"> Выберите дату и время
                        приема</label>
                    <input type="datetime-local" id="receptionDateCol"
                           name="receptionDateCol" class="form-control"
                           required>
                </div>
                <div class="modal-footer">

                    <button type="submit"
                            class="btn tn-lg btn-success">Добавить талон
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</html>
