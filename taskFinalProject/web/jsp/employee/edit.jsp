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
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${employeeListUrl}">Список
            сотрудников</a>
        </li>
        <li class="breadcrumb-item active">Редактирование сотрудника</li>
    </ul>

    <c:if test="${not empty requestScope.alert_message}">
        <div class="alert alert-danger" role="alert">
            <p><c:out value="${requestScope.alert_message}"/></p>
        </div>
    </c:if>
    <c:if test="${not empty requestScope.user}">
        <div class="row">
            <h3>Редактирование сотрудника: ${requestScope.user.surname}
                    ${requestScope.user.name}
                    ${requestScope.user.patronymic}</h3>
        </div>
        <br>

        <div class="row">
            <div class="col-md-3"><!--left col-->
                <div class="text-center">
                    <img src="data:image/png;base64,
                    ${requestScope.user.avatar}"
                         class="avatar img-circle img-thumbnail img-responsive"
                         width="250" height="250" alt="avatar">
                </div>
                <hr>
            </div>
            <hr>

            <div class="col-md-9">
                <c:url value="/employee/save.html" var="accountEditUrl"/>
                <form action="${accountEditUrl}" method="post" class="row">

                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="cabinet_number"> Cabinet number </label>
                            <input type="text" class="form-control"
                                   name="cabinet_number" id="cabinet_number"
                                   value="${requestScope.user.cabinetNumber}"
                                   placeholder="Введите номер кабинета"
                                   pattern="[0-9]{0,4}" required>
                        </div>

                        <div class="form-group">
                            <label for="salary"> Salary </label>
                            <input type="text" class="form-control"
                                   name="salary" id="salary"
                                   value="${requestScope.user.salary}"
                                   placeholder="Введите зарплату"
                                   pattern="[0-9]+([,\.][0-9]+)?"
                                   title="The number input must start with a
                                   number and use either comma or a dot as a
                                   decimal character." required>
                        </div>

                        <div class="form-group">
                            <label for="employment_date"> Date of
                                employment</label>
                            <input type="date" class="form-control"
                                   name="employment_date" id="employment_date"
                                   value="${requestScope.user.employmentDate}"
                                   placeholder="Введите дату принятия на работу"
                                   required>
                        </div>

                        <div class="form=group">
                            <label for="specialty"> Специализация </label>
                            <select class="form-control" id="specialty"
                                    name="specialty">
                                <c:forEach items="${requestScope.specialties}"
                                           var="specialty">
                                    <c:if test="${requestScope.user.specialty.id
                                     eq specialty.id}">
                                        <option selected
                                                value="${specialty.id}">
                                                ${specialty.name} </option>
                                    </c:if>
                                    <c:if test="${requestScope.user.specialty.id
                                    ne specialty.id}">
                                        <option value="${specialty.id}">
                                                ${specialty.name} </option>
                                    </c:if>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="row">
                            <input type="hidden" name="specialistId"
                                   value="${requestScope.user.id}"/>
                            <div class="form-group">
                                <div class="col">
                                    <br>
                                    <button
                                            class="btn btn-lg btn-success"
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
    </c:if>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>