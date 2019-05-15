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
        <li class="breadcrumb-item active">Список услуг</li>
    </ul>
    <div class="tab-pane">

        <main class="container pt-5">
            <div class="card mb-5">
                <div class="card-header">Список услуг</div>
                <div class="card-block p-0">
                    <table
                            class="table table-bordered table-sm m-0 table-hover">
                        <thead>
                        <tr>
                            <th> ID</th>
                            <th> Название</th>
                            <th> Описание</th>
                            <th> Цена</th>
                            <th> Длительность</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:url value="/account/service/edit.html"
                               var="serviceEditUrl"/>
                        <c:forEach items="${services}" var="service">
                            <tr onclick="submitFormById('form-${service.id}')">
                                <td><c:out value="${service.id}"/>
                                    <form id="form-${service.id}" method="post"
                                          action="${serviceEditUrl}">
                                        <input type="hidden" name="id"
                                               value="${service.id}">
                                        <input type="hidden" name="role"
                                               value="${service.id}">
                                    </form>
                                </td>

                                <td><c:out value="${service.name}"/></td>
                                <td><c:out value="${service.description}"/></td>
                                <td><c:out value="${service.price}"/></td>
                                <td><c:out value="${service.duration}"/></td>

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
                            Add service
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
