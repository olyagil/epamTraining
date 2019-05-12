<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Специалисты</title>
</head>
<body>

<%@include file="fragments/header.jsp" %>

<div class="team-section text-center my-5">

    <!-- Section heading -->
    <h2 class="h1-responsive font-weight-bold my-5">Наши специалисты</h2>
    <!-- Section description -->
    <p class="grey-text w-responsive mx-auto mb-5">Наша компания
        предоставляет огромный выбор специалистов для любых ваших
        потребностей</p>

    <!-- Grid row -->
    <div class="row">
        <!-- Grid column -->
        <c:forEach items="${specialists}" var="specialist">
            <div class="col-lg-3 col-md-6 mb-lg-0 mb-5">
                <div class="avatar mx-auto">
                    <img src="img/main.jpg" class="rounded-circle z-depth-1"
                         width="304" height="236" alt="avatar">
                </div>
                <h5 class="font-weight-bold mt-4 mb-3">
                        ${specialist.surname} ${specialist.name}</h5>
                <p class="text-uppercase blue-text">
                    <strong>${specialist.specialty.name}</strong></p>
            </div>
        </c:forEach>
        <!-- Grid column -->
    </div>
    <!-- Grid row -->
</div>


<%@include file="fragments/footer.jsp" %>

</body>
</html>
