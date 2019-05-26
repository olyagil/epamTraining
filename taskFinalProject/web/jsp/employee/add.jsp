<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
<body>
<jsp:include page="../fragments/header.jsp"/>
<jsp:include page="../fragments/menu.jsp"/>

<div class="container">
    <div class="col-md-12">
        <div class="card">
            <div class="card-header">
                <h2>Добавление сотрудника</h2>
                <p>Заполните форму, что добавить сотрудника.</p>
            </div>
            <c:url value="/employee/save.html" var="employeeSaveUrl"/>
            <div class="card-body">
                <form action="${employeeSaveUrl}" method="post" class="row"
                      enctype="multipart/form-data">
                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="login">* Логин </label>
                            <input type="text" id="login"
                                   placeholder="Enter Login"
                                   class="form-control" name="login"
                                   pattern="[a-zA-Zа-яА-Я0-9]{2,30}" required>
                        </div>

                        <div class="form-group">
                            <label for="password"> * Password </label>
                            <input type="password" id="password"
                                   placeholder="Enter password"
                                   class="form-control" name="password"
                                   pattern="[a-zA-Zа-яА-Я0-9]{2,13}" required>
                        </div>

                        <div class="form-group">
                            <label for="name"> * Name </label>
                            <input type="text" id="name"
                                   placeholder="Enter name" class="form-control"
                                   name="name"
                                   pattern="[a-zA-Zа-яА-Я]{2,30}" required>
                        </div>

                        <div class="form-group">
                            <label for="surname"> * Surname </label>
                            <input type="text" id="surname"
                                   placeholder="Enter surname"
                                   class="form-control" name="surname"
                                   pattern="[a-zA-Zа-яА-Я-]{2,30}" required>
                        </div>

                        <div class="form-group">
                            <label for="patronymic"> * Patronymic </label>
                            <input type="text" id="patronymic"
                                   placeholder="Enter patronymic"
                                   class="form-control" name="patronymic"
                                   pattern="[a-zA-Zа-яА-Я]{2,30}" required>
                        </div>

                        <div class="form-group">
                            <label for="img"> * Photo </label>
                            <input type="file" name="img" id="img"
                                   class="form-control" required>
                        </div>

                        <div class="form-group">
                            <label class="radio inline">
                                <input type="radio" name="gender"
                                       value="male">
                                <span> Male </span>
                            </label>
                            <label class="radio inline">
                                <input type="radio" name="gender"
                                       value="female" checked>
                                <span>Female </span>
                            </label>
                        </div>
                    </div>

                    <div class="col-md-5">
                        <div class="form-group">
                            <label for="phone"> * Phone </label>
                            <input type="text" id="phone"
                                   placeholder="Enter phone"
                                   class="form-control" name="phone"
                                   pattern="[0-9]{9}" required>
                        </div>

                        <div class="form-group">
                            <label for="birth_date"> * Date of birth </label>
                            <input type="date" id="birth_date"
                                   placeholder="Enter date of birth "
                                   class="form-control" name="birth_date"
                                   required>
                        </div>
                        <div class="form-group">
                            <label for="cabinet_number"> * Cabinet number
                            </label>
                            <input type="text" class="form-control"
                                   name="cabinet_number" id="cabinet_number"
                                   placeholder="Введите номер кабинета"
                                   pattern="[0-9]{0,4}" required>
                        </div>

                        <div class="form-group">
                            <label for="salary"> * Salary </label>
                            <input type="text" class="form-control"
                                   name="salary" id="salary"
                                   placeholder="Введите зарплату"
                                   pattern="[0-9]+([,\.][0-9]+)?"
                                   title="The number input must start with a
                                   number and use either comma or a dot as a
                                   decimal character." required>
                        </div>

                        <div class="form-group">
                            <label for="employment_date">* Date of
                                employment</label>
                            <input type="date" class="form-control"
                                   name="employment_date" id="employment_date"
                                   placeholder="Введите дату принятия на работу"
                                   required>
                        </div>

                        <div class="form-group">
                            <label for="specialty">* Специализация </label>
                            <select class="form-control" id="specialty"
                                    name="specialty">
                                <c:forEach items="${requestScope.specialties}"
                                           var="specialty">
                                    <option value="${specialty.id}">
                                            ${specialty.name} </option>
                                </c:forEach>
                            </select>

                        </div>

                    </div>
                    <div class="col-md-6 offset-md-6">
                        <button type="submit"
                                class="btn btn-lg btn-success">
                            Добавить
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../fragments/footer.jsp" %>

</body>
</html>
