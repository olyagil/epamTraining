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
        <div class="col-md-4">
            <div class="profile-img">
                <img src="img/main.jpg"
                     alt="avatar"/>
                <div class="file btn  btn-primary">
                    Change Photo
                    <input type="file" name="file"/>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="profile-head">
                <h5>
                    ${user.surname} ${user.name} ${user.patronymic}
                </h5>
                <h6>
                    ${user.role.name}
                </h6>
            </div>
        </div>
    </div>

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
            <div class="col-md-6">
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

        <c:if test="${user.role.id==1}">
            <div class="row">
                <div class="col-md-6">
                    <label>Cabinet number</label>
                </div>
                <div class="col-md-6">
                    <p>${user.cabinetNumber}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Salary</label>
                </div>
                <div class="col-md-6">
                    <p>${user.salary}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Employment date</label>
                </div>
                <div class="col-md-6">
                    <p>${user.employmentDate}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label>Specialty</label>
                </div>
                <div class="col-md-6">
                    <p>${user.specialty.name}</p>
                </div>
            </div>
        </c:if>
    </div>
</div>

<%@include file="../fragments/footer.jsp" %>
</body>
</html>
