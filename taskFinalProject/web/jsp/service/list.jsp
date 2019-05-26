<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Service list</title>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/js/main.js"></script>
</head>

<body>

<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <c:url value="/service/list.html" var="serviceListUrl"/>
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Список услуг</li>
    </ul>
    <div class="tab-pane">
        <button type="button" class="btn btn-primary btn-lg float-right"
                data-toggle="modal"
                data-target="#modal">Добавить услугу
        </button>

        <c:url value="/service/list.html" var="searchServiceUrl"/>
        <form action="${searchServiceUrl}" method="get"
              class="form-inline md-form mr-auto mb-4">


            <label for="search">Найти услугу по названию: </label>
            <input class="form-control mr-sm-2" aria-label="Search"
                   name="searchName" type="text" placeholder="Search"
                   id="search" pattern="[a-zA-Zа-яА-Я0-9]{2,20}" required>
            <button class="btn btn-rounded btn-primary btn-lg"
                    type="submit">Search
            </button>
        </form>
        <c:if test="${empty requestScope.services}">
            <p>Услугу с названием ${requestScope.searchName} не найдено</p>
        </c:if>
        <c:if test="${not empty requestScope.services}">
            <div class="card mb-5">
                <div class="card-header"><h2>Список услуг</h2>
                    <p>Для редактирования информации об услуге нажмите на
                        строку с услугой.</p></div>
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
                        <c:url value="/service/edit.html"
                               var="serviceEditUrl"/>
                        <c:forEach items="${requestScope.services}"
                                   var="service">
                            <tr onclick="submitFormById('form-${service.id}')">
                                <td><c:out value="${service.id}"/>
                                    <form id="form-${service.id}"
                                          action="${serviceEditUrl}">
                                        <input type="hidden" name="serviceId"
                                               value="${service.id}">
                                    </form>
                                </td>

                                <td><c:out value="${service.name}"/></td>
                                <td><c:out
                                        value="${service.description}"/></td>
                                <td><c:out value="${service.price}"/></td>
                                <td><c:out
                                        value="${service.duration}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <c:if test="${requestScope.noOfPages gt 1}">
                    <form action="${serviceListUrl}" method="post"
                          class="col text-center card-footer p-0">
                        <ul class="pagination justify-content-center mt-3">
                            <c:if test="${requestScope.currentPage != 1}">
                                <li class="page-item">
                                    <button type="submit" class="page-link"
                                            name="currentPage"
                                            value="${requestScope.currentPage
                                             - 1}">
                                        Previous
                                    </button>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${requestScope.noOfPages}"
                                       var="page">
                                <c:choose>
                                    <c:when test="${requestScope.currentPage
                                    eq page}">
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
                                            value="${requestScope.currentPage
                                             + 1}"
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
    <div class="modal fade" id="modal" tabindex="-1" role="dialog"
         aria-labelledby="label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="label"> Добавьте услугу</h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:url value="/service/save.html" var="serviceSaveUrl"/>
                    <form action="${serviceSaveUrl}" method="get">
                        <div class="form-group">
                            <label for="name"> Введите название</label>
                            <input type="text" class="form-control" id="name"
                                   name="name"
                                   placeholder="Введите название услуги"
                                   pattern="[a-zA-Zа-яА-Я0-9 ]{2,50}"
                                   required>
                        </div>

                        <div class="form-group">
                            <label for="price"> Введите цену</label>
                            <input type="text" class="form-control" id="price"
                                   name="price" placeholder="Введите цену"
                                   pattern="[0-9]+([,\.][0-9]+)?"
                                   title="The number input must start with a
                                   number and use either comma or a dot as a
                                   decimal character."
                                   required/>
                        </div>


                        <div class="form-group">
                            <label for="duration"> Введите длительность
                                (в минутах)</label>
                            <input type="text" class="form-control"
                                   id="duration" name="duration" required
                                   placeholder="Введите длительность"
                            pattern="[0-9]{0,4}"/>
                        </div>

                        <div class="form-group">
                            <label for="description"> Описание услуги</label>
                            <textarea class="form-control" rows="7"
                                      id="description"
                                      name="description"
                                      placeholder="Введите описание"
                                      required></textarea>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary"
                                    data-dismiss="modal">Закрыть
                            </button>
                            <button type="submit"
                                    class="btn btn-primary">Добавить
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
