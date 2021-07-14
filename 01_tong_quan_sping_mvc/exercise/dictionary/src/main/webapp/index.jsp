<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/14/2021
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="translate" method="post">
    <fieldset>
      <legend>Dictionary</legend>
      <label>Input: </label>
      <input type="text" id="input" name="input">
      <div id="buttons">
        <input id="reset" type="reset" tabindex="4">
        <input id="submit" type="submit" tabindex="5"
               value="Translate">
      </div>
    </fieldset>
  </form>
  </body>
</html>
