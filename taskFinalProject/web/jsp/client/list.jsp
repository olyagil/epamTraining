<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client list</title>
</head>

<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Список клиентов</li>
    </ul>
    <div class="tab-pane">
        <c:url value="/client/list.html" var="searchClientUrl"/>
        <form action="${searchClientUrl}" method="get"
              class="form-inline md-form mr-auto mb-4">
            <label for="search">Найти клиента по логину: </label>
            <input class="form-control mr-sm-4" aria-label="Search"
                   name="searchLogin" type="text" placeholder="Search"
                   id="search" required>
            <button type="submit"
                    class="btn btn-rounded btn-primary btn-lg">
                Search
            </button>
        </form>

        <c:if test="${empty requestScope.clients}">
            <p>Клиентов не найдено</p>
        </c:if>

        <c:if test="${not empty requestScope.clients}">
            <div class="card mb-5">
                <div class="card-header"><h2>Список клиентов</h2>
                    <p> Для просмотра информации о клиенте нажмите на
                        строку с клиентом</p></div>
                <div class="card-block p-0">
                    <table
                            class="table table-bordered table-sm m-0 table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Фото</th>
                            <th>Логин</th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Отчество</th>
                            <th>Пол</th>
                            <th>Телефон</th>
                            <th>Дата рождения</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:url value="/user/view.html" var="userEditUrl"/>
                        <c:forEach items="${requestScope.clients}"
                                   var="client">
                            <tr onclick="submitFormById('form-${client.id}')">
                                <td><c:out value="${client.id}"/>
                                    <form id="form-${client.id}"
                                          method="post"
                                          action="${userEditUrl}">
                                        <input type="hidden" name="id"
                                               value="${client.id}">
                                        <input type="hidden" name="role"
                                               value="${client.role.id}">
                                    </form>
                                </td>
                                <td>
                                    <img src="data:image/png;base64,
                                        ${client.avatar}" width="80"
                                         height="80"
                                         class="rounded-circle img-fluid"
                                         alt="avatar"></td>
                                <td><c:out value="${client.login}"/></td>
                                <td><c:out value="${client.surname}"/></td>
                                <td><c:out value="${client.name}"/></td>
                                <td><c:out
                                        value="${client.patronymic}"/></td>
                                <td><c:out
                                        value="${client.gender.name}"/></td>
                                <td><c:out value="${client.phone}"/></td>
                                <td><c:out
                                        value="${client.birthDate}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <c:if test="${requestScope.noOfPages gt 1}">
                    <form action="${clientListUrl}" method="get"
                          class="col text-center card-footer p-0">
                        <ul class="pagination justify-content-center mt-3">
                            <c:if test="${requestScope.currentPage != 1}">
                                <li class="page-item">
                                    <button type="submit" class="page-link"
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
                                    <button type="submit" name="currentPage"
                                            value="${requestScope.currentPage + 1}"
                                            class="page-link">Next
                                    </button>
                                </li>
                            </c:if>
                        </ul>
                    </form>
                </c:if>
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
