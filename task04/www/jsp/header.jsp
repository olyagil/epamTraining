<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="property.text" var="local"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <style>
        #navbar ul {
            display: none;
            background-color: #f90;
            position: absolute;
            top: 100%;
        }

        #navbar li:hover ul {
            display: block;
        }

        #navbar, #navbar ul {
            margin: 0;
            padding: 0;
            list-style-type: none;
        }

        #navbar {
            height: 50px;
            background-color: #666;
            min-width: 470px;
        }

        #navbar li {
            float: left;
            position: relative;
            height: 100%;
        }

        #navbar li a {
            display: block;
            padding: 16px;
            width: 125px;
            color: #fff;
            text-decoration: none;
            text-align: center;
        }

        #navbar ul li {
            float: none;
        }

        #navbar li:hover {
            background-color: #f90;
        }

        #navbar ul li:hover {
            background-color: #666;
        }
    </style>

    <fmt:message bundle="${local}" key="menu.main" var="main"/>
    <fmt:message bundle="${local}" key="menu.language" var="language"/>
    <fmt:message bundle="${local}" key="language.ru" var="ru"/>
    <fmt:message bundle="${local}" key="language.be" var="be"/>
    <fmt:message bundle="${local}" key="language.en" var="en"/>
</head>
<body>
<ul id="navbar">
    <li><a href="index.jsp">${main}</a></li>

    <li><a>${language}</a>
        <ul>
            <li><a href="?lang=RU">${ru}</a></li>
            <li><a href="?lang=be_BY">${be}</a></li>
            <li><a href="?lang=US">${en}</a></li>
        </ul>
    </li>

</ul>
<form>

    <input type="hidden" name="language" value="${language}">
</form>
</body>

</html>