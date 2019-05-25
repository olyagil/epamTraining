<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование сотрудника</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <c:url value="/account/employee/list.html" var="employeeListUrl"/>
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${employeeListUrl}">Список
            сотрудников</a>
        </li>
        <li class="breadcrumb-item active">Редактирование сотрудника</li>
    </ul>
    <div class="row">
        <%--<div class="col-md-6">--%>
        <h2>Редактирование
            сотрудника: ${user.surname} ${user.name} ${user.patronymic}</h2>
        <%--</div>--%>
    </div>
    <br>

    <div class="row">
        <div class="col-md-3"><!--left col-->
            <div class="text-center">
                <img src="data:image/png;base64, ${user.avatar}"
                     class="avatar img-circle img-thumbnail img-responsive"
                     width="250" height="250" alt="avatar">
            </div>
            <hr>
        </div>
        <hr>

        <div class="col-md-9">
            <c:url value="/employee/save.html" var="accountEditUrl"/>
            <form action="${accountEditUrl}" class="row">

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="cabinet_number"> Cabinet number </label>
                        <input type="text" class="form-control"
                               name="cabinet_number" id="cabinet_number"
                               value="${user.cabinetNumber}"
                               placeholder="Введите номер кабинета">
                    </div>

                    <div class="form-group">
                        <label for="salary"> Salary </label>
                        <input type="text" class="form-control"
                               name="salary" id="salary" value="${user.salary}"
                               placeholder="Введите телефон">
                    </div>

                    <div class="form-group">
                        <label for="employment_date"> Date of employment</label>
                        <input type="date" class="form-control"
                               name="employment_date" id="employment_date"
                               value="${user.employmentDate}"
                               placeholder="Введите дату принятия на работу">
                    </div>

                    <div class="form=group">
                        <label for="specialty"> Специализация </label>
                        <select class="form-control" id="specialty"
                                name="specialty">
                            <c:forEach items="${specialties}" var="specialty">
                                <c:if test="${user.specialty.id eq specialty.id}">
                                    <option selected value="${specialty.id}">
                                            ${specialty.name} </option>
                                </c:if>
                                <c:if test="${user.specialty.id ne specialty.id}">
                                    <option value="${specialty.id}">
                                            ${specialty.name} </option>
                                </c:if>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="row">
                        <input type="hidden" name="specialistId"
                               value="${user.id}"/>
                        <div class="form-group">
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
<%@include file="../fragments/footer.jsp" %>
</body>
</html>