<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование услуги</title>
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
        <li class="breadcrumb-item"><a href="${serviceListUrl}">Список услуг</a>
        </li>
        <li class="breadcrumb-item active">Редактирование услуги</li>
    </ul>
    <c:if test="${not empty requestScope.service}">
        <div class="row">
            <div class="col-md-7">
                <h2>Редактирование услуги</h2>
            </div>

            <c:url value="/service/delete.html" var="serviceDeleteUrl"/>
            <div class="col-md-5">

                <form action="${serviceDeleteUrl}" method="post"
                      onsubmit="return confirmation(this,
                      'Вы уверены, что хотите удалить услугу?')">
                    <input type="hidden" value="${requestScope.service.id}"
                           name="id">
                    <button class="btn btn-lg btn-danger" type="submit">Удалить
                    </button>
                </form>
            </div>
            <br>
        </div>

        <div class="col-md-9">
            <c:url value="/service/save.html" var="serviceSaveUrl"/>
            <form action="${serviceSaveUrl}" class="row">
                <div class="col-md-6">
                    <input type="hidden" value="${requestScope.service.id}"
                           name="id">
                    <div class="form-group">
                        <label for="name"> Name </label>
                        <input type="text" class="form-control"
                               name="name" id="name"
                               value="${requestScope.service.name}"
                               placeholder="Введите название услуги"
                               pattern="[a-zA-Zа-яА-Я0-9 ]{2,50}" required>
                    </div>

                    <div class="form-group">
                        <label for="price"> Price </label>
                        <input type="text" class="form-control"
                               name="price" id="price"
                               value="${requestScope.service.price}"
                               placeholder="Введите цену"
                               pattern="[0-9]+([,\.][0-9]+)?"
                               title="The number input must start with a
                                   number and use either comma or a dot as a
                                   decimal character." required>
                    </div>

                    <div class="form-group">
                        <label for="duration"> Длительность (в миутах) </label>
                        <input type="text" class="form-control"
                               name="duration" id="duration"
                               value="${requestScope.service.duration}"
                               placeholder="Введите длительность"
                               pattern="[0-9]{0,4}" required>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="form-group">
                        <label for="description">Описание услуги </label>
                        <textarea class="form-control" rows="8"
                                  id="description"
                                  placeholder="Введите описание"
                                  name="description" required><c:out
                                value="${requestScope.service.description}"/>
                        </textarea>
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
    </c:if>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>