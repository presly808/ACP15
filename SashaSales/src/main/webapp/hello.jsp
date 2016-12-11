<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 12.12.2016
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Ajax</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<div id="my-content" type="text">
    <label>Input name</label>
    <input id="nameInput" type="text"><br>
    <button onclick="sendAjaxReqJquery()">Send Ajax req</button>
    <div id="responseText"></div>

</div>
</body>

<script>

    function sendAjaxReqJquery() {
        var name = $("#nameInput").val();
        var confObj = {
            type: "GET",
            url: "ajax/hello",
            data: {name : name},
            success: function (result) {
                $("#responseText").html(result);
            }
        };
        $.ajax(confObj);
    }

</script>

</html>
