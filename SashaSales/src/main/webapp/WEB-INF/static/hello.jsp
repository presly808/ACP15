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
</head>
<body>

<div id="my-content" type="text">
    <label>Input name</label>
    <input id="nameInput" type="text"><br>
    <button onclick="sendReq()">Send Ajax req</button>
    <div id="responseText"></div>

</div>
</body>

<script>

    function sendReq() {

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseText").innerHTML = xhttp.responseText;
            }
        };

        var name = document.getElementById("nameInput").value;
        xhttp.open("GET", "ajax/hello" + "?name=" + name, true);
        xhttp.send();

    }

</script>

</html>
