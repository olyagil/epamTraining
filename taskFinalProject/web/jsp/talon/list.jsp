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
        <li class="breadcrumb-item active">Список талонов</li>
    </ul>
    <c:if test="${sessionScope.role eq 0}">
        <div class="btn-group">
            <form action="${talonListUrl}" method="post" class="col-md-4">
                <input type="hidden" name="status" value="true">
                <button type="submit" class="btn btn-primary btn-lg">
                    Выполненные
                </button>
            </form>

            <form action="${talonListUrl}" method="post" class="col-md-6">
                <input type="hidden" name="status" value="false">
                <button type="submit" class="btn btn-primary btn-lg">
                    Не выполненные
                </button>
            </form>
            <c:if test="${sessionScope.role ne 2}">
                <c:url value="/talon/add.html" var="talonAddUrl"/>
                <form action="${talonAddUrl}" method="post" class="col-md-12">
                    <button type="submit"
                            class="btn btn-primary btn-lg float-right">
                        Добавить талон
                    </button>
                </form>
            </c:if>
        </div>


        <div class="row">
            <form action="${talonListUrl}" method="get"
                  class="form-inline md-form mr-auto mb-4">
                <label for="search">Найти талон по дате: </label>
                <input class="form-control mr-sm-2" aria-label="Search"
                       name="searchDate" type="date" placeholder="Search"
                       id="search" required>
                <button class="btn btn-rounded btn-primary btn-lg"
                        type="submit">Search
                </button>
            </form>
        </div>
        <c:if test="${empty requestScope.talons}">
            <p>Талонов на ${requestScope.searchDate} не найдено</p>
        </c:if>
    </c:if>
    <div class="row">
        <c:if test="${not empty sessionScope.success_save_talon}">
            <div class="alert alert-success" role="alert">
                    ${sessionScope.success_save_talon}
                <c:remove var="success_save_talon" scope="session"/>
                <c:remove var="talonId" scope="session"/>
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.failure_save_talon}">
            <div class="alert alert-danger" role="alert">
                    ${sessionScope.failure_save_talon}
                <c:remove var="failure_save_talon" scope="session"/>
                <c:remove var="talonId" scope="session"/>
            </div>
        </c:if>
    </div>
    <div class="tab-pane">
        <div class="card mb-5">
            <div class="card-header">Список талонов</div>
            <div class="card-block p-0">
                <table class="table table-bordered table-sm m-0 table-hover">
                    <thead>
                    <tr>
                        <th> ID</th>
                        <c:if test="${sessionScope.role ne 2}">
                            <th> ФИО клиента</th>
                            <th> Телефон</th>
                        </c:if>
                        <c:if test="${sessionScope.role ne 1}">
                            <th> ФИО специалиста</th>
                            <th> Телефон</th>
                        </c:if>
                        <th> Название процедуры</th>
                        <th> Дата</th>
                        <c:if test="${sessionScope.role eq 2}">
                            <th> Отзывы</th>
                        </c:if>
                        <c:if test="${sessionScope.role ne 2}">
                            <th> Статус</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:url value="/talon/edit.html" var="talonEditUrl"/>
                    <c:forEach items="${requestScope.talons}" var="talon">
                        <c:choose>
                            <c:when test="${sessionScope.role eq 0}">
                                <tr
                                onclick="submitFormById('form-${talon.id}')">
                                <td><c:out value="${talon.id}"/>
                                    <form id="form-${talon.id}"
                                          method="post"
                                          action="${talonEditUrl}">
                                        <input type="hidden" name="id"
                                               value="${talon.id}">
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td><c:out value="${talon.id}"/></td>
                            </c:otherwise>
                        </c:choose>
                        <c:if test="${sessionScope.role ne 2}">
                            <td><c:out value="${talon.client.surname}
                                               ${talon.client.name}"/></td>
                            <td><c:out
                                    value="${talon.client.phone}"/></td>
                        </c:if>
                        <c:if test="${sessionScope.role ne 1}">
                            <td><c:out value="${talon.employee.surname}
                                            ${talon.employee.name} "/>
                            <td><c:out
                                    value="${talon.employee.phone}"/></td>
                        </c:if>
                        <td><c:out value="${talon.service.name}"/></td>
                        <td><c:out value="${talon.receptionDate}"/></td>
                        <c:if test="${sessionScope.role ne 2}">
                            <td><c:out value="${talon.status}"/></td>
                        </c:if>

                        <c:if test="${sessionScope.role eq 2}">
                            <td>
                                <c:url value="/feedback/add.html"
                                       var="feedbackAddUrl"/>
                                <form action="${feedbackAddUrl}"
                                      method="post">
                                    <input type="hidden" name="talonId"
                                           value="${talon.id}">
                                    <button type="submit"
                                            class="btn btn-primary">
                                        Оставить отзыв
                                    </button>
                                </form>
                            </td>
                        </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="col text-center card-footer p-0">
                <c:if test="${noOfPages gt 1}">
                    <form action="${talonListUrl}" method="post"
                          class="col text-center card-footer p-0">
                        <ul class="pagination justify-content-center mt-3">
                            <c:if test="${currentPage != 1}">
                                <li class="page-item">
                                    <button type="submit" class="page-link"
                                            name="currentPage"
                                            value="${currentPage - 1}">
                                        Previous
                                    </button>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${noOfPages}"
                                       var="page">
                                <c:choose>
                                    <c:when test="${currentPage eq page}">
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

                            <c:if test="${currentPage lt noOfPages}">
                                <li class="page-item">
                                    <button type="submit" name="currentPage"
                                            value="${currentPage + 1}"
                                            class="page-link">Next
                                    </button>
                                </li>
                            </c:if>
                        </ul>
                    </form>
                </c:if>

            </div>
        </div>
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
