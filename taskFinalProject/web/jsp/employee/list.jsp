<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee list</title>
</head>

<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Список сотрудников</li>
    </ul>
    <div class="tab-pane">
        <c:url value="/employee/add.html" var="employeeAddUrl"/>
        <form action="${employeeAddUrl}" method="post">
            <button type="submit"
                    class="btn btn-primary btn-lg float-right">
                Add Employee
            </button>
        </form>

        <form action="${employeeListUrl}" method="get"
              class="form-inline md-form mr-auto mb-4">
            <label for="search">Найти клиента по логину: </label>
            <input class="form-control mr-sm-2" aria-label="Search"
                   name="searchLogin" type="text" placeholder="Search"
                   id="search" required>
            <button class="btn btn-rounded btn-primary btn-lg"
                    type="submit">Search
            </button>
        </form>
        <c:if test="${empty requestScope.employees}">
            <p>Специалиста с логином ${searchLogin} не найдено</p>
        </c:if>
        <c:if test="${not empty requestScope.employees}">
                <div class="card mb-5">
                    <div class="card-header"><h2>Список сотрудников</h2>
                    <p>Для просмотра информации о сотруднике нажмите на
                        строку с сотрудником</p></div>
                    <div class="card-block p-0">
                        <table
                                class="table table-bordered table-sm m-0 table-hover">
                            <thead>
                            <tr>
                                <th> ID</th>
                                <th> Фото</th>
                                <th> Логин</th>
                                <th> Фамилия</th>
                                <th> Имя</th>
                                <th> Отчество</th>
                                <th> Пол</th>
                                <th> Телефон</th>
                                <th> Дата рождения</th>
                                <th> Кабинет</th>
                                <th> Оклад</th>
                                <th> Дата</th>
                                <th> Специальность</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:url value="/user/view.html" var="userEditUrl"/>
                            <c:forEach items="${requestScope.employees}"
                                       var="employee">
                                <tr onclick="submitFormById('form-${employee.id}')">
                                    <td><c:out value="${employee.id}"/>
                                        <form id="form-${employee.id}"
                                              method="get"
                                              action="${userEditUrl}">
                                            <input type="hidden" name="id"
                                                   value="${employee.id}">
                                            <input type="hidden" name="role"
                                                   value="${employee.role.id}">
                                        </form>
                                    </td>
                                    <td><img src="data:image/png;base64,
                                        ${employee.avatar}"
                                             width="100" height="100"
                                             class="rounded-circle img-fluid"
                                             alt="avatar"></td>
                                    <td><c:out
                                            value="${employee.login}"/></td>
                                    <td><c:out
                                            value="${employee.surname}"/></td>
                                    <td><c:out value="${employee.name}"/></td>
                                    <td><c:out
                                            value="${employee.patronymic}"/></td>
                                    <td><c:out
                                            value="${employee.gender.name}"/></td>
                                    <td><c:out
                                            value="${employee.phone}"/></td>
                                    <td><c:out
                                            value="${employee.birthDate}"/></td>
                                    <td><c:out
                                            value="${employee.cabinetNumber}"/></td>
                                    <td><c:out
                                            value="${employee.salary}"/></td>
                                    <td><c:out
                                            value="${employee.employmentDate}"/></td>
                                    <td><c:out
                                            value="${employee.specialty.name}"/></td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="col text-center card-footer p-0">
                        <c:if test="${requestScope.noOfPages gt 1}">
                            <form action="${employeeListUrl}" method="get"
                                  class="col text-center card-footer p-0">
                                <ul class="pagination justify-content-center mt-3">
                                    <c:if test="${requestScope.currentPage != 1}">
                                        <li class="page-item">
                                            <button type="submit"
                                                    class="page-link"
                                                    name="currentPage"
                                                    value="${requestScope.currentPage - 1}">
                                                Previous
                                            </button>
                                        </li>
                                    </c:if>

                                    <c:forEach begin="1"
                                               end="${requestScope.noOfPages}"
                                               var="page">
                                        <c:choose>
                                            <c:when test="${requestScope.currentPage eq page}">
                                                <li class="page-item active">
                                                    <button type="submit"
                                                            class="page-link"
                                                            disabled>
                                                            ${page}
                                                        <span class="sr-only">(current)</span>
                                                    </button>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item">
                                                    <button type="submit"
                                                            class="page-link"
                                                            name="currentPage"
                                                            value="${page}">
                                                            ${page}</button>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                    <c:if test="${requestScope.currentPage lt
                                requestScope.noOfPages}">
                                        <li class="page-item">
                                            <button type="submit"
                                                    name="currentPage"
                                                    value="${requestScope.currentPage + 1}"
                                                    class="page-link">Next
                                            </button>
                                        </li>
                                    </c:if>
                                </ul>
                            </form>
                        </c:if>
                    </div>
                </div>

        </c:if>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
<script> function submitFormById(id) {
    var form = document.getElementById(id);
    var isSubmit = true;
    if (form.onsubmit != null) {
        isSubmit = form.onsubmit();
    }
    if (isSubmit) {
        form.submit();
    }
    return false;
}</script>
</body>
</html>
