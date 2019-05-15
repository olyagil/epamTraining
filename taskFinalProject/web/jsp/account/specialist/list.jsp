<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee list</title>
</head>

<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/sidebar.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <c:url value="/account/service/list.html" var="serviceListUrl"/>
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Список сотрудников</li>
    </ul>
    <div class="tab-pane">

        <main class="container pt-5">
            <div class="card mb-5">
                <div class="card-header">Список сотрудников</div>
                <div class="card-block p-0">
                    <table
                            class="table table-bordered table-sm m-0 table-hover">
                        <thead>
                        <tr>
                            <th> ID</th>
                            <th> Логин</th>
                            <th> Фамилия</th>
                            <th> Имя</th>
                            <th> Отчество</th>
                            <th> Пол</th>
                            <th> Телефон</th>
                            <th> Дата рождения</th>
                            <th> Номер кабинета</th>
                            <th> Оклад</th>
                            <th> Дата</th>
                            <th> Специальность</th>
                            <th> Фото</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:url value="/account/user/view.html"
                               var="userEditUrl"/>
                        <c:forEach items="${specialists}" var="specialist">
                            <tr onclick="submitFormById('form-${specialist.id}')">
                                <td><c:out value="${specialist.id}"/>
                                    <form id="form-${specialist.id}"
                                          method="post"
                                          action="${userEditUrl}">
                                        <input type="hidden" name="id"
                                               value="${specialist.id}">
                                        <input type="hidden" name="role"
                                               value="${specialist.role.id}">
                                    </form>
                                </td>

                                <td><c:out value="${specialist.login}"/></td>
                                <td><c:out value="${specialist.surname}"/></td>
                                <td><c:out value="${specialist.name}"/></td>
                                <td><c:out
                                        value="${specialist.patronymic}"/></td>
                                <td><c:out
                                        value="${specialist.gender.name}"/></td>
                                <td><c:out value="${specialist.phone}"/></td>
                                <td><c:out
                                        value="${specialist.birthDate}"/></td>
                                <td><c:out
                                        value="${specialist.cabinetNumber}"/></td>
                                <td><c:out value="${specialist.salary}"/></td>
                                <td><c:out
                                        value="${specialist.employmentDate}"/></td>
                                <td><c:out
                                        value="${specialist.specialty.name}"/></td>
                                <td><c:out value="${specialist.avatar}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="col text-center card-footer p-0">

                    <ul class="pagination justify-content-center mt-3">
                        <li class="page-item">
                            <a class="page-link" href="#">Previous</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                    <c:url value="/account/add.html#employee"
                           var="accountAddUrl"/>
                    <form action="${accountAddUrl}" method="post">
                        <button type="submit"
                                class="btn btn-primary float-right">
                            Add User
                        </button>
                    </form>


                </div>
            </div>
        </main>
    </div>
</div>
<%@include file="../../fragments/footer.jsp" %>
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
