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
    <title>Result</title>
</head>
<body>
<fieldset>
    <legend>Calculator Simple</legend>
    <label>Input: </label>
    <input type="text" id="textA" name="textA" value="${textA}">
    <input type="text" id="textB" name="textB" value="${textB}">

    <div id="buttons" style="margin-top: 10px">
        <input id="addition" name="calculator" type="submit" tabindex="5"
               value="Addition(+)">
        <input id="subtraction" name="calculator" type="submit" tabindex="5"
               value="Subtraction(-)">
        <input id="multiplication" name="calculator" type="submit" tabindex="5"
               value="Multiplication(x)">
        <input id="division" name="calculator" type="submit" tabindex="5"
               value="Division(/)">
    </div>
    <p>Result = ${result}</p>
</fieldset>
</body>
</html>
