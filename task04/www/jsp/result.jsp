<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<c:set var="lang" value="${sessionScope.lang}"/>--%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="property.text" var="local"/>
<!DOCTYPE html>
<html>
<head>
    <title>Vouchers</title></head>
<fmt:message bundle="${local}" key="table.id" var="id"/>
<fmt:message bundle="${local}" key="table.data" var="data"/>
<fmt:message bundle="${local}" key="table.number.nights" var="nights"/>
<fmt:message bundle="${local}" key="table.country" var="country"/>
<fmt:message bundle="${local}" key="table.transport" var="transport"/>
<fmt:message bundle="${local}" key="table.cost" var="cost"/>
<fmt:message bundle="${local}" key="table.hotel" var="hotelcharacteristics"/>
<fmt:message bundle="${local}" key="table.price" var="price"/>
<fmt:message bundle="${local}" key="table.currency" var="currency"/>
<fmt:message bundle="${local}" key="table.flight.include" var="flight"/>
<fmt:message bundle="${local}" key="table.hotel.include" var="hotel"/>
<fmt:message bundle="${local}" key="table.tv" var="tv"/>
<fmt:message bundle="${local}" key="table.fan" var="fan"/>
<fmt:message bundle="${local}" key="table.safe" var="safe"/>
<fmt:message bundle="${local}" key="table.wifi" var="wifi"/>
<fmt:message bundle="${local}" key="table.number.stars" var="stars"/>
<fmt:message bundle="${local}" key="table.room.type" var="room"/>
<fmt:message bundle="${local}" key="table.meal.type" var="meal"/>
<%--<c:import url="header.jsp"/>--%>
<meta charset="utf-8">
<style>
    body {
        background-color: #f0f0f0;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: center;
        padding: 8px;
    }

    th {
        background-color: rgba(191, 191, 191, 0.58);

    }

</style>

<body>

<table border="2">
    <caption>Vouchers</caption>
    <thead>
    <tr>
        <th rowspan="2">${id}</th>
        <th rowspan="2">${data}</th>
        <th rowspan="2">${nights}</th>
        <th rowspan="2">${country}</th>
        <th rowspan="2">${transport}</th>
        <th colspan="4">${cost}</th>
        <th colspan="7">${hotelcharacteristics}</th>
    </tr>
    <tr>
        <th>${price}</th>
        <th>${currency}</th>
        <th>${flight}</th>
        <th>${hotel}</th>
        <th>${tv}</th>
        <th>${fan}</th>
        <th>${safe}</th>
        <th>${wifi}</th>
        <th>${stars}</th>
        <th>${room}</th>
        <th>${meal}</th>
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

</body>
</html>
