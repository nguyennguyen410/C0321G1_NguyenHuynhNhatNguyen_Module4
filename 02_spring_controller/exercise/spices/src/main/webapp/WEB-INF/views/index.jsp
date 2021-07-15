<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/15/2021
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="save" method="get">
    <fieldset>
        <legend>Sandwich</legend>
        <label>Chosse Spices: </label>
        <input type="checkbox" id="lettuce" name="spices" value="lettuce"> Lecttuce
        <input type="checkbox" id="tomato" name="spices" value="tomato"> Tomato
        <input type="checkbox" id="mustard" name="spices" value="mustard"> Mustard
        <input type="checkbox" id="sprouts" name="spices" value="sprouts"> Sprouts
        <div id="buttons">
            <input id="submit" type="submit" tabindex="5"
                   value="Save">
        </div>
    </fieldset>
</form>
</body>
</html>
