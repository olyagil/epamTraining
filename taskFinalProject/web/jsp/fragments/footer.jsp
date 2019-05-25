<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="property.lang"/>
<html>
<head>
    <title>Footer</title>
</head>
<body>

<!-- Footer -->
<footer class="page-footer font-small blue-grey lighten-5">

    <!-- Footer Links -->
    <div class="container text-center text-md-left mt-5">

        <!-- Grid row -->
        <div class="row mt-3 dark-grey-text">

            <!-- Grid column -->
            <div class="col-md-3 col-lg-4 col-xl-3 mb-4">

                <!-- Content -->
                <h6 class="text-uppercase font-weight-bold">Косметический
                    салон "Солнышко"</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px;">
                <p>Lorem ipsum dolor sit amet,
                    consectetur
                    adipisicing elit.</p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 col-lg-2 col-xl-3 mx-auto mb-4">
                <!-- Links -->
                <h6 class="text-uppercase font-weight-bold">Меню</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px;">
                <c:url value="/services.html" var="servicesUrl"/>
                <p><a class="dark-grey-text" href="${servicesUrl}">
                    <fmt:message key="header.services"/></a>
                </p>
                <c:url value="/employees.html" var="specialistUrl"/>
                <p><a class="dark-grey-text" href="${specialistUrl}">
                    <fmt:message key="header.specialists"/>
                </a>
                    <c:url value="/feedback.html" var="feedbackUrl"/>
                <p><a class="dark-grey-text" href="${feedbackUrl}">
                    <fmt:message key="header.feedback"/></a>
                </p>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto  mb-4">
                <!-- Links -->
                <h6 class="text-uppercase font-weight-bold">Contact</h6>
                <hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px;">
                <p><i class="fa fa-envelope mr-3"></i><a href="mailto:olya.gil@mail.ru?subject=EPAM trainig">
                    olya.gil@mail.ru</a></p>
                <p><i class="fa fa-phone mr-3"></i><a href="tel:+375-33-303-62-01">+ 375 (33) 303 62 01</a></p>
            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

    </div>
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center text-black-50 py-3">Copyright
        Gil Olga © 2019
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->

</body>
</html>
