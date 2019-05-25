<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование услуги</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <c:url value="/service/list.html" var="serviceListUrl"/>
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item"><a href="${serviceListUrl}">Список услуг</a>
        </li>
        <li class="breadcrumb-item active">Редактирование услуги</li>
    </ul>
    <div class="row">
        <div class="col-md-7">
            <h2>Редактирование услуги</h2>
        </div>

        <c:if test="${not empty service}">
            <c:url value="/service/delete.html" var="serviceDeleteUrl"/>
            <div class="col-md-5">

                <form action="${serviceDeleteUrl}" method="post">
                    <input type="hidden" value="${service.id}" name="id">
                    <button class="btn btn-lg btn-danger" type="submit">Удалить
                    </button>
                </form>
            </div>
        </c:if>
        <br>
    </div>
    <div class="col-md-9">
        <c:url value="/service/save.html" var="serviceSaveUrl"/>
        <form action="${serviceSaveUrl}" class="row">
            <div class="col-md-6">
                <input type="hidden" value="${service.id}" name="id">
                <div class="form-group">
                    <label for="name"> Name </label>
                    <input type="text" class="form-control"
                           name="name" id="name" value="${service.name}"
                           placeholder="Введите название услуги" required>
                </div>

                <div class="form-group">
                    <label for="price"> Price </label>
                    <input type="text" class="form-control"
                           name="price" id="price" value="${service.price}"
                           placeholder="Введите цену" required>
                </div>

                <div class="form-group">
                    <label for="duration"> Длительность </label>
                    <input type="text" class="form-control"
                           name="duration" id="duration"
                           value="${service.duration}"
                           placeholder="Введите длительность" required>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label for="description">Описание услуги </label>
                    <textarea class="form-control" rows="8"
                              id="description" placeholder="Введите описание"
                              name="description" required
                    >${service.description}</textarea>
                </div>
                <div class="row">
                    <div class="form-group">
                        <div class="col">
                            <br>
                            <button class="btn btn-lg btn-success"
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
<%@include file="../fragments/footer.jsp" %>
</body>
</html>