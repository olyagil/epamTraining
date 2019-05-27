<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="property.lang"/>
<html>
<head>
    <title><fmt:message key="feedback.add"/></title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">
            <fmt:message key="menu.main"/>
        </a></li>
        <li class="breadcrumb-item"><a href="${talonListUrl}">
            <fmt:message key="menu.talon.list"/> </a></li>
        <li class="breadcrumb-item active"><fmt:message
                key="feedback.add"/></li>
    </ul>
    <div class="row">
        <div class="col-md-6">
            <h2><fmt:message key="feedback.add"/></h2></div>
    </div>

    <div class="row">

        <div class="col-md-9">
            <c:url value="/feedback/save.html" var="feedbackSaveUrl"/>
            <form action="${feedbackSaveUrl}" class="row" method="post">
                <div class="col-md-5">
                    <br>
                    <p><b><fmt:message key="service.name"/> </b><c:out
                            value="${requestScope.talon.service.name}"/>
                        <br><br> <b><fmt:message key="employee.name"/>: </b>
                        <c:out value="${requestScope.talon.employee.surname}
                        ${requestScope.talon.employee.name}"/>
                        <br><br><b><fmt:message key="service.date"/>: </b>
                        <c:out value="${requestScope.talon.receptionDate}"/>
                    </p>
                </div>

                <div class="col-md-7">
                    <div class="form-group">
                        <fmt:message key="placeholder.feedback" var="feedback"/>
                        <label for="review">
                            <fmt:message key="feedback"/> </label>
                        <textarea class="form-control" rows="8" cols="7"
                                  id="review"
                                  placeholder="${feedback}"
                                  name="review" required></textarea>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col">
                                <input type="hidden" name="employeeId"
                                       value="${requestScope.talon.employee.id}">
                                <button class="btn btn-lg btn-success"
                                        type="submit"><fmt:message
                                        key="button.save"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>