<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Group</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<div class="addgroup-container">

    <h1>Add Group to DB University</h1>

    <label>Create group:</label>
    <input id="group_name" type="text"><br>
    <button onclick="sendAjaxReqJquery()">Send Ajax req</button>
    <div id="responseText"></div>

    <a href="/index.jsp">Back</a>

</div>

<div id="responseList" class="bottom" onclick="sendAjaxReqGetGroups()">

    <h2>Press to show Group list>></h2>
   <%-- <button onclick="sendAjaxReqGetGroups()">Send Ajax req list group</button>
    <div id="responseList"></div>
--%>
</div>

<style type="text/css">
    .addgroup-container{
        width: 50%;
        height: 50%;
        position: absolute;
        color: #2135ff;
        top: 10%;
        left: 5%;
    }

    .bottom{
        width: 50%;
        height: 50%;
        display: table;
        color: #ff36ed;
        position: absolute;
        top: 10%;
        left: 50%;

    }
</style>

</body>

<script>

    function sendAjaxReqJquery() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("group_name").value;
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseText").innerHTML = xhttp.responseText;
            }
        };

        xhttp.open("POST", "addgroup" + "?name=" + name, true);
        xhttp.send();

    }

    function sendAjaxReqGetGroups() {

        var xhttp = new XMLHttpRequest();

        xhttp.open("GET", "getgroups?page=1&size=30", true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseList").innerHTML = xhttp.responseText;
            }
        };

    }


    /*function sendAjaxReqJquery() {
        var group_name = $("#group_name").val();
        var confObj = {
            type: "POST",
            url: "addgroup",
            data: {name : group_name},
            success: function (result) {
                $("#responseText").html(result);
            }
        };
        $.ajax(confObj);
    }
*/
</script>

</html>
