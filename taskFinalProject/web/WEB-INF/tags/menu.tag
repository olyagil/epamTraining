<%@tag language="java" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
    <h1>Косметический салон<br>«Солнце»</h1>
    <c:if test="${not empty authorizedUser}">
        <ul class="right">
            <c:forEach items="${menu}" var="item">
                <c:url value="${item.url}" var="itemUrl"/>
                <li class="item"><a href="${itemUrl}">${item.name}</a></li>
            </c:forEach>
            <li class="item">
                <c:url value="/img/arrow.gif" var="arrowUrl"/>
                <a href="#" class="drop-button">${authorizedUser.login} <IMG
                        class="arrow" src="${arrowUrl}"></a>
                <ol class="drop">
                    <c:url value="/profile/edit.html" var="profileEditUrl"/>
                    <li><a href="${profileEditUrl}">профиль</a></li>
                    <c:url value="/logout.html" var="logoutUrl"/>
                    <a><a href="${logoutUrl}">выход</a></a>
                </ol>
            </li>
        </ul>
    </c:if>
</div>
