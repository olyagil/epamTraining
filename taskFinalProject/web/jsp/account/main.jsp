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
        <div class="col-sm-10"><h2>Welcome, ${loggedUser.login}</h2></div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-4"><!--left col-->
            <div class="text-center">
                <img src="data:image/png;base64, ${loggedUser.avatar}"
                     class="avatar img-circle img-thumbnail img-responsive"
                     alt="avatar">
            </div>
        </div>

        <div class="col-sm-8">

            <div class="row">
                <div class="col-md-6">
                    <div>
                        <h5>${loggedUser.surname} ${loggedUser.name} ${loggedUser.patronymic}</h5>
                        <h6> ${loggedUser.role.name} </h6>
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
                        <p>${loggedUser.login}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <label>ФИО</label>
                    </div>
                    <div class="col-md-6">
                        <p>${loggedUser.surname} ${loggedUser.name} ${loggedUser.patronymic}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Gender</label>
                    </div>
                    <div class="col-md-6">
                        <p>${loggedUser.gender.name}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Phone</label>
                    </div>
                    <div class="col-md-6">
                        <p>${loggedUser.phone}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Date of birth</label>
                    </div>
                    <div class="col-md-6">
                        <p>${loggedUser.birthDate}</p>
                    </div>
                </div>

                <c:if test="${loggedUser.role.id eq 1}">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Cabinet number</label>
                        </div>
                        <div class="col-md-6">
                            <p>${loggedUser.cabinetNumber}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Salary</label>
                        </div>
                        <div class="col-md-6">
                            <p>${loggedUser.salary}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Employment date</label>
                        </div>
                        <div class="col-md-6">
                            <p>${loggedUser.employmentDate}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Specialty</label>
                        </div>
                        <div class="col-md-6">
                            <p>${loggedUser.specialty.name}</p>
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
