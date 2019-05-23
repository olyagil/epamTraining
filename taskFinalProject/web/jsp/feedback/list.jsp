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
    <div class="row">
        <div class="panel panel-default widget">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-comment"></span>
                <h3 class="panel-title">
                    Recent Comments</h3>
            </div>
            <div class="panel-body">
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <c:url value="/user/view.html"
                                   var="feedbackViewUrl"/>
                            <c:forEach items="${requestScope.feedbacks}"
                                       var="feedback">
                                <div class="col-xs-2 col-md-1">
                                    <img src="data:image/png;base64,
                                ${feedback.client.avatar}" width="80"
                                         height="80"
                                         class="img-responsive rounded"
                                         alt="avatar"/>
                                </div>
                                <div class="col-xs-10 col-md-11">
                                    <div class="mic-info"
                                         onclick="submitFormById('form-${feedback.client.id}')">
                                        <form id="form-${feedback.client.id}"
                                              method="get"
                                              action="${feedbackViewUrl}">
                                            <input type="hidden" name="id"
                                                   value="${feedback.client.id}">
                                            <input type="hidden" name="role"
                                                   value="${feedback.client.role.id}">
                                        </form>
                                        <p>
                                            By: <font color="#6495ed">
                                                ${feedback.client.surname}
                                                ${feedback.client.name}</font>
                                            on ${feedback.date}</p>
                                    </div>
                                    <div class="comment-text">
                                        <p> ${feedback.review}</p>
                                    </div>
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
                                    <c:url value="/feedback/delete.html"
                                           var="feedbackDelete"/>
                                    <form action="${feedbackDelete}"
                                          method="post">
                                        <input type="hidden" name="feedbackId"
                                               value="${feedback.id}">
                                        <button type="submit"
                                                class="btn btn-danger btn-xs float-right"
                                                title="Delete">Удалить
                                        </button>
                                    </form>
                                </div>
                                <hr>

                            </c:forEach>
                        </div>
                    </li>
                </ul>
                <a href="#" class="btn btn-primary btn-sm btn-block"
                   role="button">More</a>
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
