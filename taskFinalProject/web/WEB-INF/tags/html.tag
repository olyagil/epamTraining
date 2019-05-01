<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/strict.dtd">

<%@tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" rtexprvalue="true"
             type="java.lang.String" %>
<%@attribute name="message" required="false" rtexprvalue="true"
             type="java.lang.String" %>
<%@attribute name="validator" required="false" rtexprvalue="true"
             type="java.lang.String" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<HTML>
<HEAD>
    <%--<META http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <TITLE>Косметический салон - ${title}</TITLE>
    <c:url value="/main.css" var="cssUrl"/>
    <LINK rel="stylesheet" type="text/css" href="${cssUrl}">
    <%--<meta charset="utf-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <c:url value="/js" var="javascriptUrl"/>
    <SCRIPT type="text/javascript" src="${javascriptUrl}/main.js"></SCRIPT>
    <c:if test="${not empty message}">
        <SCRIPT type="text/javascript">
            startMessage = "${message}";
        </SCRIPT>
    </c:if>
    <c:if test="${not empty validator}">
        <SCRIPT type="text/javascript"
                src="${javascriptUrl}/validator.js"></SCRIPT>
        <SCRIPT type="text/javascript"
                src="${javascriptUrl}/${validator}"></SCRIPT>
    </c:if>
</HEAD>
<BODY>
<u:menu/>
<DIV id="page">
    <jsp:doBody/>
</DIV>
</BODY>
</HTML>