<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-sm-10"><h2>Welcome,
            ${requestScope.loggedUser.login}</h2></div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-4"><!--left col-->
            <div class="text-center">
                <img src="data:image/png;base64, ${requestScope.loggedUser.avatar}"
                     class="avatar img-circle img-thumbnail img-responsive"
                     alt="avatar">
            </div>
        </div>

        <div class="col-sm-8">

            <div class="row">
                <div class="col-md-6">
                    <div>
                        <h5><c:out value="${requestScope.loggedUser.surname}
                            ${requestScope.loggedUser.name}
                            ${requestScope.loggedUser.patronymic}"/></h5>
                        <h6><c:out
                                value="${requestScope.loggedUser.role.name}"/></h6>
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
                        <p><c:out value="${requestScope.loggedUser.login}"/></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <label>ФИО</label>
                    </div>
                    <div class="col-md-6">
                        <p><c:out value="${requestScope.loggedUser.surname}
                            ${requestScope.loggedUser.name}
                            ${requestScope.loggedUser.patronymic}"/></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Gender</label>
                    </div>
                    <div class="col-md-6">
                        <p><c:out
                                value="${requestScope.loggedUser.gender.name}"/></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Phone</label>
                    </div>
                    <div class="col-md-6">
                        <p><c:out value="${requestScope.loggedUser.phone}"/></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Date of birth</label>
                    </div>
                    <div class="col-md-6">
                        <p><c:out
                                value="${requestScope.loggedUser.birthDate}"/></p>
                    </div>
                </div>

                <c:if test="${requestScope.loggedUser.role.id eq 1}">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Cabinet number</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.loggedUser.cabinetNumber}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Salary</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.loggedUser.salary}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Employment date</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.loggedUser.employmentDate}"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Specialty</label>
                        </div>
                        <div class="col-md-6">
                            <p><c:out
                                    value="${requestScope.loggedUser.specialty.name}"/></p>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>
</body>
</html>
