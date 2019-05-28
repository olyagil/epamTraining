<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="property.lang"/>
<html>
<head>
    <title><fmt:message key="menu.feedback.list"/></title>
    <script type="text/javascript"
            src="${pageContext.servletContext.contextPath}/js/main.js"></script>
</head>

<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>


<div class="container">
    <ul class="breadcrumb">
        <li class="breadcrumb-item"><a href="${accountMainUrl}">
            <fmt:message key="menu.main"/>
        </a></li>
        <li class="breadcrumb-item active">
            <fmt:message key="menu.feedback.list"/></li>
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
                    <c:choose>
                    <c:when test="${sessionScope.role ne 2}">
                    <div class="mic-info"
                         onclick="submitFormById('form-${feedback.client.id}')">
                        </c:when>
                        <c:otherwise>
                        <div class="mic-info">
                            </c:otherwise>
                            </c:choose>
                            <form id="form-${feedback.client.id}"
                                  method="get" action="${feedbackViewUrl}">
                                <input type="hidden" name="id"
                                       value="${feedback.client.id}">
                                <input type="hidden" name="role"
                                       value="${feedback.client.role.id}">
                            </form>
                            <p><fmt:message key="feedback.by"/> :
                                <span style="color:#6495ed">
                                    <c:out value="${feedback.client.surname}
                                    ${feedback.client.name}"/></span>
                                <span class="float-right text-secondary">
                                       <c:out value="${feedback.date}"/></span>
                            </p>
                        </div>
                        <div class="clearfix"></div>
                        <p><c:out value="${feedback.review}"/></p>
                        <c:choose>
                        <c:when test="${sessionScope.role ne 2}">
                        <div class="to_whom"
                             onclick="submitFormById('form-${feedback.employee.id}')">
                            </c:when>
                            <c:otherwise>
                            <div class="to_whom">
                                </c:otherwise>
                                </c:choose>
                                <form id="form-${feedback.employee.id}"
                                      method="get" action="${feedbackViewUrl}">
                                    <input type="hidden" name="id"
                                           value="${feedback.employee.id}">
                                    <input type="hidden" name="role"
                                           value="${feedback.employee.role.id}">
                                </form>
                                <p><fmt:message key="feedback.on"/>
                                    <span style="color: #6495ed">
                                        <c:out value="${feedback.employee.surname}
                                    ${feedback.employee.name}"/></span>
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
                                        <i class="fa fa-reply"></i>
                                        <fmt:message key="button.delete"/>
                                    </button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

            <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
                <form action="${feedbackListUrl}" method="get">

                    <button type="submit" name="currentPage"
                            value="${requestScope.currentPage+1}"
                            class="btn btn-primary btn-sm btn-block">
                        <fmt:message key="button.more"/>
                    </button>
                </form>
            </c:if>
        </div>
    </div>
</div>

<%@include file="../fragments/footer.jsp" %>

</body>
</html>
