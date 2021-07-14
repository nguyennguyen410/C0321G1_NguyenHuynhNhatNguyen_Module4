<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/14/2021
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="convert" method="post">
    <fieldset>
      <legend>Ty gia 23.000d/1$</legend>
      <label>Nhap so luong USD: </label>
      <input type="text" id="usd" name="usd">
      <div id="buttons">
        <input id="reset" type="reset" tabindex="4">
        <input id="submit" type="submit" tabindex="5"
               value="Convert">
      </div>
    </fieldset>
  </form>
  </body>
</html>
