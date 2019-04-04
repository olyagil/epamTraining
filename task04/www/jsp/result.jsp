<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Core: forEach</title></head>

<body>
<table>
    <c:forEach var="elem" items="${res}" varStatus="status">
 <tr>
  <td><c:out value="${ elem.id }" /></td>
  <td><c:out value="${ elem.beginData }" /></td>
  <td><c:out value="${ elem.numberNights }" /></td>
  <td><c:out value="${ elem.country }" /></td>
  <td><c:out value="${ elem.transport }" /></td>
  <td><c:out value="${ elem.cost.price }" /></td>
   <td><c:out value="${ elem.cost.flightInclude }" /></td>
      <td><c:out value="${ elem.cost.hotelInclude }" /></td>
 <td><c:out value="${ elem.hotelCharacteristic.tv }" /></td>
  <td><c:out value="${ elem.hotelCharacteristic.fan }" /></td>
   <td><c:out value="${ elem.hotelCharacteristic.safe }" /></td>
    <td><c:out value="${ elem.hotelCharacteristic.wifi }" /></td>
     <td><c:out value="${ elem.hotelCharacteristic.numberStars }" /></td>
          <td><c:out value="${ elem.hotelCharacteristic.room-type }" /></td>
     <td><c:out value="${ elem.hotelCharacteristic.meal-type }" /></td>


 </tr>
    </c:forEach>
</table>
</body></html>
