<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Feedback list</title>
</head>

<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>


<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">Главная</a></li>
        <li class="breadcrumb-item active">Отзывы</li>
    </ul>
    <c:url value="/user/view.html" var="feedbackViewUrl"/>
    <c:forEach items="${requestScope.feedbacks}" var="feedback">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <img src="data:image/png;base64,
                        ${feedback.client.avatar}" alt="avatar"
                             class="img rounded-circle img-fluid"/>
                    </div>
                    <div class="col-md-10">
                        <div class="mic-info"
                             onclick="submitFormById('form-${feedback.client.id}')">
                            <form id="form-${feedback.client.id}"
                                  method="get" action="${feedbackViewUrl}">
                                <input type="hidden" name="id"
                                       value="${feedback.client.id}">
                                <input type="hidden" name="role"
                                       value="${feedback.client.role.id}">
                            </form>
                            <p> By: <font color="#6495ed">
                                    ${feedback.client.surname}
                                    ${feedback.client.name}</font>
                                <span class="float-right text-secondary">
                                        ${feedback.date}</span>
                            </p>
                        </div>
                        <div class="clearfix"></div>
                        <p>${feedback.review}</p>
                        <div class="to_whom"
                             onclick="submitFormById('form-${feedback.employee.id}')">
                            <form id="form-${feedback.employee.id}"
                                  method="get"
                                  action="${feedbackViewUrl}">
                                <input type="hidden" name="id"
                                       value="${feedback.employee.id}">
                                <input type="hidden" name="role"
                                       value="${feedback.employee.role.id}">
                            </form>
                            <p> на <font color="#6495ed">
                                    ${feedback.employee.surname}
                                    ${feedback.employee.name}</font>
                            </p>
                        </div>


                        <c:if test="${sessionScope.role ne 1}">
                            <c:url value="/feedback/delete.html"
                                   var="feedbackDelete"/>
                            <form action="${feedbackDelete}"
                                  method="post">
                                <input type="hidden" name="feedbackId"
                                       value="${feedback.id}">
                                <button type="submit"
                                        class="float-right btn btn-danger text-white"
                                        title="Delete">
                                    <i class="fa fa-reply"></i> Удалить
                                </button>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <form action="${feedbackListUrl}" method="get">

                <button type="submit" name="currentPage"
                        value="${requestScope.currentPage+1}"
                        class="btn btn-primary btn-sm btn-block">More
                </button>
            </form>
        </c:if>
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
