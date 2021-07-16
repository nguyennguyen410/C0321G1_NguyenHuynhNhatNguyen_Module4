<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/16/2021
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Settings</title>
</head>
<body>
<form:form action="edit" method="post" modelAttribute="emailEdited">
    <fieldset>
        <legend><h3>Email Settings</h3></legend>
        <table>
            <tr>
                <td><form:label path="languages">Languages:</form:label></td>
                <td>${emailEdited.languages}</td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>${emailEdited.pageSize}</td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
                <td>${emailEdited.spamsFilter}</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td>${emailEdited.signature}</td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
