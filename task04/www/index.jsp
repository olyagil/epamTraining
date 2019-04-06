    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="UTF-8">
        <c:if test="${empty param.language}">
            <c:set var="language" value='en'/>
        </c:if>
        <c:set var="language"
               value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
               scope="session"/>

        <fmt:setLocale value="${language}"/>
        <fmt:setBundle basename="property.text" var="local"/>
        <fmt:message bundle="${local}" key="title" var="title"/>
        <fmt:message bundle="${local}" key="button.send" var="send"/>
        <fmt:message bundle="${local}" key="button.parse" var="parse"/>
        <fmt:message bundle="${local}" key="message.choose" var="choose"/>
        <title>Web Parser</title>
        </head>
        <body style="background-color:rgb(240, 240, 240);">

        <div>
        <c:import url="jsp/header.jsp"/>
        <h1>${title}</h1>
        </div>


        <form enctype="multipart/form-data" method="post">
        <p><input type="file" name="f" accept="application/xml">
       ${choose}
        <select name="parser">
        <option abbr title="Simple API for XML">SAX parser</option>
        <option abbr title="Streaming API for XML">StAX parser</option>
        <option abbr title="Document Object Model">DOM parser</option>
        </select>
        <input type="submit" value=${send}></p>
        </form>



        <button onclick="location.href='parse'">${parse}</button>
        <c:import url="jsp/test.jsp"/>
        <input type="hidden" name="lang" value="${language}">
        </body>
        </html>
