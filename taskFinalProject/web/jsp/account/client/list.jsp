<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client list</title>
</head>

<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/sidebar.jsp" %>

<div class="tab-pane" id="clientlist">
    <hr>
    <main class="container pt-5">
        <div class="card mb-5">
            <div class="card-header">Список клиентов</div>
            <div class="card-block p-0">
                <table class="table table-bordered table-sm m-0 table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Логин</th>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Отчество</th>
                        <th>Пол</th>
                        <th>Телефон</th>
                        <th>Дата рождения</th>
                        <th>Фото</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${clients}" var="client">
                        <tr>
                            <td><c:out value="${client.id}"/></td>
                            <td><c:out value="${client.login}"/></td>
                            <td><c:out value="${client.surname}"/></td>
                            <td><c:out value="${client.name}"/></td>
                            <td><c:out value="${client.patronymic}"/></td>
                            <td><c:out value="${client.gender.name}"/></td>
                            <td><c:out value="${client.phone}"/></td>
                            <td><c:out value="${client.birthDate}"/></td>
                            <td><c:out value="${client.avatar}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-footer p-0">
                <nav aria-label="...">
                    <ul class="pagination justify-content-end mt-3 mr-3">
                        <li class="page-item disabled">
                            <span class="page-link">Previous</span>
                        </li>
                        <li class="page-item"><a class="page-link"
                                                 href="#">1</a></li>
                        <li class="page-item active">
                            <span class="page-link">2<span class="sr-only">(current)</span>
                            </span>
                        </li>
                        <li class="page-item"><a class="page-link"
                                                 href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </nav>

                <c:url var="/account/edit.html" value="${accountEditUrl}"/>
                <form action="${accountEditUrl}" method="post">
                    <button class="btn btn-primary" type="submit">Add User
                    </button>
                </form>
            </div>
        </div>
    </main>
</div>
<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
