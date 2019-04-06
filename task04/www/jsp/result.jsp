    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <!DOCTYPE html>
        <html>
        <head>
        <title>Core: forEach</title></head>
        <c:import url="header.jsp"/>
        <meta name="theme-color" content="#ffffff">
        <meta charset="utf-8">

        <body style="background-color:rgb(240,240,240);">>
        <table border = "1" width="100%" cellpadding="1" class="w3-table-all
        notranslate">
        <thead>
        <tr>
        <th h1 style="font-family:verdana;">ID</th>
        <th style="text-align:center;">Begin data</th>
        <th>Nh>ber of nights</th>
        <th>Country</th>
        <th>Transport</th>
        <th>Price</th>
        <th>Currency</th>
        <th>flight include</th>
        <th style="font-size:6px;">hotel include</th>
        <th>TV</th>
        <th>Fan</th>
        <th>Safe</th>
        <th>WI-FI</th>
        <th>Number stars</th>
        <th>Room type</th>
        <th>Meal type</th>
        </tr>
        </thead>
        <c:forEach var="elem" items="${res}" varStatus="status">
            <tr>
            <td><c:out value="${ elem.id }"/></td>
            <td><c:out value="${ elem.beginData }"/></td>
            <td><c:out value="${ elem.numberNights }"/></td>
            <td><c:out value="${ elem.country }"/></td>
            <td><c:out value="${ elem.transport }"/></td>
            <td><c:out value="${ elem.cost.price }"/></td>
            <td><c:out value="${ elem.cost.currency }"/></td>
            <td><c:out value="${ elem.cost.flightInclude }"/></td>
            <td><c:out value="${ elem.cost.hotelInclude }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.tv }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.fan }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.safe }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.wiFi }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.numberStars }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.roomType }"/></td>
            <td><c:out value="${ elem.hotelCharacteristic.mealType }"/></td>
            </tr>
        </c:forEach>
        </table>

        </body></html>
