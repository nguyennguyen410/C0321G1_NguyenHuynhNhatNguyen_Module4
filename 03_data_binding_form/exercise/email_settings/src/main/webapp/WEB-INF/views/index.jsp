<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/16/2021
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form:form action="edit" method="post" modelAttribute="email">
    <fieldset>
        <legend><h3>Email Settings</h3></legend>
        <table>
            <tr>
                <td><form:label path="languages">Languages:</form:label></td>
                <td>
                    <form:select path="languages">
                        <form:option value="NONE" label="languages"/>
                        <form:option value="English"/>
                        <form:option value="VietNam"/>
                        <form:option value="US"/>
                        <form:option value="France"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label>show</td>
                <td>
                    <form:select path="pageSize">
                        <form:option value="25" label="pageSize"/>
                        <form:option value="25"/>
                        <form:option value="30"/>
                        <form:option value="35"/>
                        <form:option value="40"/>
                    </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
                <td><form:checkbox path="spamsFilter" value="enable"/>Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature:</form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Update</form:button>
                    <button style="margin-left: 5px" type="button" onclick="cancel()">Cancel</button></td>
            </tr>
        </table>
    </fieldset>
</form:form>

</body>
<script>
    function cancel() {
        location.href = "index";
    }
</script>
</html>
