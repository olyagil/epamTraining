<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../fragments/header.jsp" %>
<%@include file="../../fragments/sidebar.jsp" %>

<div class="container">
    <c:url value="/account/user/edit.html" var="userEditUrl"/>
    <c:url value="/account/user/delete.html" var="userDeleteUrl"/>
    <br>
    <div class="row">

        <div class="col-sm-4"><!--left col-->
            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                     class="avatar img-circle img-thumbnail img-responsive"
                     alt="avatar">
            </div>
        </div>
        <div class="col-sm-8">

            <div class="row">
                <div class="col-md-6">
                    <div>
                        <h5>${user2.surname} ${user2.name}
                            ${user2.patronymic}</h5>
                        <h6> ${user2.role.name} </h6>
                    </div>
                </div>
                <div class="col text-right">
                    <div class="btn-group">
                        <%--<form action="${userEditUrl}" method="get"--%>
                        <%--class="col-md-6">--%>
                        <%--<button type="submit" class="btn btn-primary">--%>
                        <%--Редактировать--%>
                        <%--</button>--%>
                        <%--</form>--%>

                        <form action="${userDeleteUrl}" method="post"
                              class="col-md-6">
                            <button class="btn btn-lg btn-primary" type="submit"
                                    name="id"
                                    value="${user2.id}">Удалить
                            </button>
                        </form>
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
                        <p>${user2.login}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <label>ФИО</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user2.surname} ${user2.name}
                            ${user2.patronymic}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Gender</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user2.gender.name}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Phone</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user2.phone}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Date of birth</label>
                    </div>
                    <div class="col-md-6">
                        <p>${user2.birthDate}</p>
                    </div>
                </div>

                <c:if test="${user2.role.id eq 1}">
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


<%@include file="../../fragments/footer.jsp" %>
</body>
</html>
