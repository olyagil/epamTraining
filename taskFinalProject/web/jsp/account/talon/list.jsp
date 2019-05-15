<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Service list</title>
</head>

<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/sidebar.jsp" %>
<div class="container">
    <ul class="breadcrumb">
        <c:url value="/account/service/list.html" var="serviceListUrl"/>
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Список талонов</li>
    </ul>
    <div class="tab-pane">

        <main class="container pt-5">
            <div class="card mb-5">
                <div class="card-header">Список талонов</div>
                <div class="card-block p-0">
                    <table class="table table-bordered table-sm m-0 table-hover">
                        <thead>
                        <tr>
                            <th> ID</th>
                            <th> Имя</th>
                            <th> Фамилия</th>
                            <th> Отчество</th>
                            <th> Телефон</th>
                            <th> Название процедуры</th>
                            <th> Дата</th>
                            <th> Статус</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:url value="/account/talon/edit.html"
                               var="talonEditUrl"/>
                        <c:forEach items="${talons}" var="talon">
                            <tr onclick="submitFormById('form-${talon.id}')">
                                <td><c:out value="${talon.id}"/>
                                    <form id="form-${talon.id}" method="post"
                                          action="${talonEditUrl}">
                                        <input type="hidden" name="id"
                                               value="${talon.id}">
                                    </form>
                                </td>

                                <td><c:out
                                        value="${talon.client.surname}"/></td>
                                <td><c:out value="${talon.client.name}"/></td>
                                <td><c:out value="${talon.client.patronymic}"/>
                                </td>
                                <td><c:out value="${talon.client.phone}"/></td>
                                <td><c:out value="${talon.receptionDate}"/></td>
                                <td><c:out value="${talon.status}"/></td>

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
                    <c:url value="/account/service/edit.html"
                           var="serviceEditUrl"/>
                    <form action="${serviceEditUrl}" method="post">
                        <button type="submit"
                                class="btn btn-primary float-right">
                            Add talon
                        </button>
                    </form>
                    <button type="button" class="btn btn-lg" data-toggle="modal"
                            data-target="#modal">Добавить талон
                    </button>

                </div>
            </div>
        </main>
    </div>
    <div class="modal fade" id="modal" tabindex="-1" role="dialog"
         aria-labelledby="label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="label"> Добавьте талон</h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:url value="/account/talon/save.html" var="talonSave"/>
                    <form action="${talonSave}" method="get">
                        <div class="form-group">
                            <label for="service"> Выберите услугу </label>
                            <select class="form-control selectpicker"
                                    id="service"
                                    name="serviceId" data-live-search="true">
                                <c:forEach items="${services}" var="service">
                                    <option value="${service.id}">
                                            ${service.name} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="specialist"> Выберите
                                специалиста</label>
                            <select class="form-control" id="specialist"
                                    name="specialistId">
                                <option selected value="${user.id}">
                                    ${user.surname}
                                    ${user.name} </option>
                            </select>
                        </div>


                        <div class="form-group">
                            <label for="clients"> Выберите клиента</label>
                            <select class="form-control selectpicker"
                                    data-live-search="true" id="clients"
                                    name="clientId">
                                <c:forEach items="${clients}" var="client">
                                    <option value="${client.id}">
                                            ${client.surname} ${client.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="receptionDate"> Выберите дату и время
                                приема</label>
                            <input type="datetime-local" id="receptionDate"
                                   name="receptionDate" class="form-control"
                                   required>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary"
                                    data-dismiss="modal">Close
                            </button>
                            <button type="submit" class="btn btn-primary">Send
                                message
                            </button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>

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
