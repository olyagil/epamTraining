<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<%@include file="../fragments/header.jsp" %>
<%@include file="../fragments/menu.jsp" %>

<div class="container register">

    <div class="row">
        <div class="col-md-3">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Welcome</h3>
            <p>You are 30 seconds away from earning your own money!</p>
        </div>
        <div class="col-md-9">
            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="employee-tab"
                       data-toggle="tab"
                       href="#employee" role="tab" aria-controls="employee"
                       aria-selected="true">Сотрудник</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="client-tab" data-toggle="tab"
                       href="#client" role="tab" aria-controls="client"
                       aria-selected="false">Клиент</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="employee"
                     role="tabpanel" aria-labelledby="employee-tab"><br>
                    <h4 class="text-center">Добавить сотрудника</h4>
                    <hr>
                    <c:url value="/account/user/save.html"
                           var="accountSaveUrl"/>
                    <form action="${accountSaveUrl}" class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="role">* Role</label>
                                <select class="form-control" id="role"
                                        name="role">
                                    <option>Сотрудник</option>
                                    <option disabled>Клиент</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="login">* Login</label>
                                <input type="text" class="form-control"
                                       placeholder="Login *" name="login"
                                       id="login"/>
                            </div>
                            <div class="form-group">
                                <label for="password">* Password</label>
                                <input type="password" class="form-control"
                                       placeholder="Password *"
                                       name="password" id="password"/>
                            </div>
                            <div class="form-group">
                                <label for="password-repeat">* Repeat
                                    password</label>
                                <input type="password" class="form-control"
                                       placeholder="Confirm Password *"
                                       name="password-repeat"
                                       id="password-repeat"/>
                            </div>
                            <div class="form-group">
                                <label for="surname">* Surname</label>
                                <input type="text" class="form-control"
                                       placeholder="Surname *"
                                       name="surname" id="surname"/>
                            </div>
                            <div class="form-group">
                                <label for="name">* Name</label>
                                <input type="text" class="form-control"
                                       placeholder="Name *" name="name"
                                       id="name"/>
                            </div>
                            <div class="form-group">
                                <label for="patronymic">* Patronymic</label>
                                <input type="text" class="form-control"
                                       placeholder="Patronymic *"
                                       name="patronymic" id="patronymic"/>
                            </div>

                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="gender"
                                               value="male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="gender"
                                               value="female">
                                        <span>Female </span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="phone">* Phone</label>
                            <div class="form-group">
                                <input type="text" name="phone"
                                       class="form-control"
                                       placeholder="Phone *" id="phone"/>
                            </div>
                            <div class="form-group">
                                <label for="birthDate">* Date of birth</label>
                                <input type="date" class="form-control"
                                       placeholder="Date of birth*"
                                       name="birthDate" id="birthDate"/>
                            </div>
                            <div class="form-group">
                                <label for="cabinetNumber">* Cabinet
                                    number</label>
                                <input type="text" class="form-control"
                                       placeholder="Cabinet number *"
                                       name="cabinetNumber" id="cabinetNumber"/>
                            </div>
                            <div class="form-group">
                                <label for="salary">* Salary</label>
                                <input type="text" class="form-control"
                                       placeholder="Salary *"
                                       name="salary" id="salary"/>
                            </div>
                            <div class="form-group">
                                <label for="employmentDate">* Employment
                                    date</label>
                                <input type="date" class="form-control"
                                       placeholder="Date of employment*"
                                       name="employmentDate"
                                       id="employmentDate"/>
                            </div>
                            <div class="form-group">
                                <label for="specialty">* Specialty</label>
                                <select class="form-control" id="specialty"
                                        name="specialty">
                                    <option>Косметолог</option>
                                    <option>Дерматолог</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="avatar">Photo</label>
                                <input type="file" class="form-control"
                                       placeholder="Avatar " id="avatar"
                                       name="avatar"/>
                            </div>

                            <input type="submit" class="btn btn-primary"
                                   value="Добавить"/>
                        </div>
                    </form>
                </div>

                <div class="tab-pane fade show" id="client" role="tabpanel"
                     aria-labelledby="client-tab"><br>
                    <h3 class="text-center">Добавить клиента</h3>
                    <hr>
                    <form action="${accountSaveUrl}" class="row register-form">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="role">* Role</label>
                                <select class="form-control" name="role"
                                        id="role">
                                    <option>Клиент</option>
                                    <option disabled>Сотрудник</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="login">* Login</label>
                                <input type="text" class="form-control"
                                       placeholder="Login *" name="login"
                                       id="login"/>
                            </div>

                            <div class="form-group">
                                <label for="password">* Password</label>
                                <input type="password" class="form-control"
                                       placeholder="Password *"
                                       name="password" id="password"/>
                            </div>

                            <div class="form-group">
                                <label for="password-repeat">* Repeat
                                    password</label>
                                <input type="password" class="form-control"
                                       placeholder="Confirm Password *"
                                       name="password-repeat"
                                       id="password-repeat"/>
                            </div>

                            <div class="form-group">
                                <label for="avatar">Photo</label>
                                <input type="file" class="form-control"
                                       placeholder="Avatar " id="avatar"
                                       name="avatar"/>
                            </div>

                            <div class="form-group">
                                <div class="maxl">
                                    <label class="radio inline">
                                        <input type="radio" name="gender"
                                               value="male" checked>
                                        <span> Male </span>
                                    </label>
                                    <label class="radio inline">
                                        <input type="radio" name="gender"
                                               value="female">
                                        <span>Female </span>
                                    </label>
                                </div>
                            </div>

                        </div>

                        <div class="col-md-6">

                            <div class="form-group">
                                <label for="surname">* Surname</label>
                                <input type="text" class="form-control"
                                       placeholder="Surname *"
                                       name="surname" id="surname"/>
                            </div>

                            <div class="form-group">
                                <label for="name">* Name</label>
                                <input type="text" class="form-control"
                                       placeholder="Name *" name="name"
                                       id="name"/>
                            </div>

                            <div class="form-group">
                                <label for="patronymic">* Patronymic</label>
                                <input type="text" class="form-control"
                                       placeholder="Patronymic *"
                                       name="patronymic" id="patronymic"/>
                            </div>

                            <div class="form-group">
                                <label for="phone">* Phone</label>
                                <input type="text" name="phone"
                                       class="form-control"
                                       placeholder="Phone *" id="phone"/>
                            </div>

                            <div class="form-group">
                                <label for="birthDate">* Date of birth</label>
                                <input type="date" class="form-control"
                                       placeholder="Date of birth*"
                                       name="birthDate" id="birthDate"/>
                            </div>
                            <input type="submit" class="btn btn-primary"
                                   value="Добавить"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="../fragments/footer.jsp" %>

</body>
</html>
