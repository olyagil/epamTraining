<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Услуги</title>
</head>
<body>

<%@include file="fragments/header.jsp" %>

<div class="team-section text-center my-5">
    <input type="hidden">
    <!-- Section heading -->
    <h2 class="h1-responsive font-weight-bold my-5">Наши услуги</h2>
    <!-- Section description -->
    <p class="grey-text w-responsive mx-auto mb-5">Наша компания
        предоставляет огромный выбор услуг для любых ваших
        потребностей</p>
    <div class="row mt-5">
        <c:forEach items="${services}" var="service">
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">
                <div class="card">
                    <div class="card-block block-1">
                        <h3 class="card-title">${service.name}</h3>
                        <p class="card-text">${service.description}</p>


                    </div>
                </div>

            </div>
        </c:forEach>
    </div>


    <%--<section id="what-we-do">--%>
    <%--<div class="container-fluid">--%>
    <%--<h2 class="section-title mb-2 h1">What we do</h2>--%>
    <%--<p class="text-center text-muted h5">Having and managing a correct--%>
    <%--marketing strategy is crucial in a fast moving market.</p>--%>
    <%----%>
    <%--<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">--%>
    <%--<div class="card">--%>
    <%--<div class="card-block block-2">--%>
    <%--<h3 class="card-title">Special title</h3>--%>
    <%--<p class="card-text">With supporting text below as a--%>
    <%--natural lead-in to additional content.</p>--%>
    <%--<a href="javascript:void();" title="Read more"--%>
    <%--class="read-more">Read more<i--%>
    <%--class="fa fa-angle-double-right ml-2"></i></a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">--%>
    <%--<div class="card">--%>
    <%--<div class="card-block block-3">--%>
    <%--<h3 class="card-title">Special title</h3>--%>
    <%--<p class="card-text">With supporting text below as a--%>
    <%--natural lead-in to additional content.</p>--%>
    <%--<a href="javascript:void();" title="Read more"--%>
    <%--class="read-more">Read more<i--%>
    <%--class="fa fa-angle-double-right ml-2"></i></a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">--%>
    <%--<div class="card">--%>
    <%--<div class="card-block block-4">--%>
    <%--<h3 class="card-title">Special title</h3>--%>
    <%--<p class="card-text">With supporting text below as a--%>
    <%--natural lead-in to additional content.</p>--%>
    <%--<a href="javascript:void();" title="Read more"--%>
    <%--class="read-more">Read more<i--%>
    <%--class="fa fa-angle-double-right ml-2"></i></a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">--%>
    <%--<div class="card">--%>
    <%--<div class="card-block block-5">--%>
    <%--<h3 class="card-title">Special title</h3>--%>
    <%--<p class="card-text">With supporting text below as a--%>
    <%--natural lead-in to additional content.</p>--%>
    <%--<a href="javascript:void();" title="Read more"--%>
    <%--class="read-more">Read more<i--%>
    <%--class="fa fa-angle-double-right ml-2"></i></a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 col-xl-4">--%>
    <%--<div class="card">--%>
    <%--<div class="card-block block-6">--%>
    <%--<h3 class="card-title">Special title</h3>--%>
    <%--<p class="card-text">With supporting text below as a--%>
    <%--natural lead-in to additional content.</p>--%>
    <%--<a href="javascript:void();" title="Read more"--%>
    <%--class="read-more">Read more<i--%>
    <%--class="fa fa-angle-double-right ml-2"></i></a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</section>--%>
    <!-- /Services section -->
    <%@include file="fragments/footer.jsp" %>

</body>
</html>

