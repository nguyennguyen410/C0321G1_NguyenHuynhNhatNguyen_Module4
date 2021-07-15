<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/15/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="result" method="get">
    <fieldset>
        <legend>Calculator Simple</legend>
        <label>Input: </label>
        <input type="text" id="textA" name="textA">
        <input type="text" id="textB" name="textB">

        <div id="buttons" style="margin-top: 10px">
            <input id="addition" name="operator" type="submit" tabindex="5"
                   value="Addition(+)">
            <input id="subtraction" name="operator" type="submit" tabindex="5"
                   value="Subtraction(-)">
            <input id="multiplication" name="operator" type="submit" tabindex="5"
                   value="Multiplication(*)">
            <input id="division" name="operator" type="submit" tabindex="5"
                   value="Division(/)">
        </div>
    </fieldset>
</form>

</body>
</html>
