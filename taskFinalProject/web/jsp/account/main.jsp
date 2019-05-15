<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/sidebar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-sm-10"><h2>Welcome, ${user.login}</h2></div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-4"><!--left col-->
            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                     class="avatar img-circle img-thumbnail img-responsive"
                     alt="avatar">
                <h6>Upload a different photo...</h6>
                <input type="file" class="text-center center-block file-upload">
            </div>
            <hr>
        </div>
        <div class="col-sm-8">

            <div class="row">
                <div class="col-md-6">
                    <div>
                        <h5>${user.surname} ${user.name} ${user.patronymic}</h5>
                        <h6> ${user.role.name} </h6>
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
                        <p>${user.login}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <label>ФИО</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user.surname} ${user.name} ${user.patronymic}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Gender</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user.gender.name}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Phone</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user.phone}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Date of birth</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user.birthDate}</p>
                    </div>
                </div>

                <c:if test="${user.role.id eq 1}">
                    <div class="row">
                        <div class="col-md-6">
                            <label>Cabinet number</label>
                        </div>
                        <div class="col-md-6">
                            <p>${user2.cabinetNumber}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Salary</label>
                        </div>
                        <div class="col-md-6">
                            <p>${user2.salary}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Employment date</label>
                        </div>
                        <div class="col-md-6">
                            <p>${user2.employmentDate}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Specialty</label>
                        </div>
                        <div class="col-md-6">
                            <p>${user2.specialty.name}</p>
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
