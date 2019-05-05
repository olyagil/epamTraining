<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="u" tagdir="/WEB-INF/tags" %>
<u:html title="List Of Clients">

    <%--<jsp:include page="jsp/header.jsp"/>--%>
    <h2>Список:</h2>
    <table>
        <tr>
            <th>Login</th>
            <th>Role</th>
        </tr>
        <%--<c:url value="/user/edit.html" var="userEditUrl"/>--%>

        <c:forEach var="userInfo" items="${clients}" >
            <%--<TR onclick="submitFormById('form-${userInfo.id}')">--%>
                <td>${userInfo.login}
                    <FORM id="form-${userInfo.identity}" command="${userEditUrl}"
                          method="post">
                        <INPUT type="hidden" name="id" value="${userInfo.id}">
                    </FORM>
                </td>
                <td>${userInfo.role}</td>
            <td>${userInfo.name}</td>
            </TR>
        </c:forEach>

    </table>

</u:html>
