<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Feedback</title>

</head>
<body>
<jsp:include page="fragments/header.jsp"/>

<div class="container container mt-4 mb-5">
    <h3 class="display-4 text-center"> Отзывы </h3>
    <hr class="bg-dark mb-4 w-25">
    <p class="lead grey-text text-center w-responsive mx-auto mb-5">Комфорт
        клиента для нас на первом месте</p>


    <div class="row">
        <c:forEach items="${requestScope.feedback}" var="feedback">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top"
                         src="data:image/png;base64,
                         ${feedback.client.avatar}"
                         alt="avatar">
                    <div class="card-block p-3">
                        <h4 class="card-title"> ${feedback.client.surname}
                                ${feedback.client.name}</h4>
                        <p class="card-text"> ${feedback.review}</p>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@include file="fragments/footer.jsp" %>
</body>
</html>
