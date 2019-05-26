<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <c:url value="/employee/edit.html" var="userEditUrl"/>
    <c:url value="/user/delete.html" var="userDeleteUrl"/>
    <br>
    <div class="row">
        <c:if test="${not empty requestScope.user}">
            <div class="col-sm-4"><!--left col-->
                <div class="text-center">
                    <img src="data:image/png;base64,${requestScope.user.avatar}"
                         class="avatar img-circle img-thumbnail img-responsive"
                         width="250" height="250" alt="avatar">
                </div>
            </div>

            <div class="col-sm-8">
                <div class="row">
                    <div class="col-md-6">
                        <div>
                            <h5><c:out value="${requestScope.user.surname}
                            ${requestScope.user.name}
                            ${requestScope.user.patronymic}"/></h5>
                            <h6><c:out
                                    value="${requestScope.user.role.name}"/></h6>
                        </div>
                    </div>
                    <div class="col text-right">
                        <div class="btn-group">
                            <c:if test="${sessionScope.role eq 0}">
                                <form action="${userEditUrl}"
                                      method="get"
                                      class="col-md-6">
                                    <input type="hidden" name="specialistId"
                                           value="${requestScope.user.id}">
                                    <button type="submit"
                                            class="btn btn-primary btn-lg">
                                        Редактировать
                                    </button>
                                </form>

                                <form action="${userDeleteUrl}" method="post"
                                      class="col-md-6">
                                    <input type="hidden" name="userRole"
                                           value="${requestScope.user.role.id}">
                                    <button class="btn btn-lg btn-primary"
                                            type="submit"
                                            name="userId"
                                            value="${requestScope.user.id}">
                                        Удалить
                                    </button>
                                </form>
                            </c:if>
                        </div>

                    </div>
                </div>
                <hr>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Login</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out value="${requestScope.user.login}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <label>ФИО</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.user.surname}
                                ${requestScope.user.name}
                            ${requestScope.user.patronymic}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Gender</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.user.gender.name}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Phone</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out value="${requestScope.user.phone}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Date of birth</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.user.birthDate}"/></p>
                        </div>
                    </div>

                    <c:if test="${requestScope.user.role.id eq 1}">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Cabinet number</label>
                            </div>
                            <div class="col-md-6">
                                <p><c:out
                                        value="${requestScope.user.cabinetNumber}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Salary</label>
                            </div>
                            <div class="col-md-6">
                                <p><c:out
                                        value="${requestScope.user.salary}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Employment date</label>
                            </div>
                            <div class="col-md-6">
                                <p><c:out
                                        value="${requestScope.user.employmentDate}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Specialty</label>
                            </div>
                            <div class="col-md-6">
                                <p><c:out
                                        value="${requestScope.user.specialty.name}"/></p>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </c:if>
    </div>

</div>

<br><br>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
