<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="lang" value="${sessionScope.lang}"/>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="property.text" var="local"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <fmt:message bundle="${local}" key="title" var="title"/>
    <fmt:message bundle="${local}" key="button.send" var="send"/>
    <fmt:message bundle="${local}" key="button.parse" var="parse"/>
    <fmt:message bundle="${local}" key="message.choose" var="choose"/>
    <title>${title}</title>
</head>
<body style="background-color:rgb(240, 240, 240);">

<c:import url="jsp/header.jsp"/>
<p><b>${choose}</b></p>
<form action="parse" enctype="multipart/form-data" method="post">

    <label><input type="radio" name="parser" title="SAX" value="SAX" required>
        SAX</label> <br>
    <label><input type="radio" name="parser" title="StAX" value="StAX"
                   required>StAX</label><br>
    <label><input type="radio" name="parser" title="DOM" value="DOM"
                  required>DOM</label><br><br>

    <input type="hidden" name="parser" value="parser">
    <input type="file" name="file" accept="application/xml" required>
    <input type="submit" value=${parse}>
    <%--<input type="hidden" name="lang" value="${lang}">--%>

</form>

<c:import url="jsp/result.jsp"/>

</body>
</html>
