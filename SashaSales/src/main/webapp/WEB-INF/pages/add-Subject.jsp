<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Subject</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<div class="container">

    <h1>Add Subject to DB University</h1>

    <label>Input subject name:</label>
    <input id="subject_name" type="text"><br>
    <label>Input subject description:</label>
    <input id="subject_description" type="text">
    <br>
    <button onclick="sendAjaxReqSubject()">Send Ajax req</button>

    <a href="/index.jsp">Back</a>

    <div id="responseTextSubject"></div>

</div>

</body>

<script>

    function sendAjaxReqSubject() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("subject_name").value;
        var description = document.getElementById("subject_description").value;
        xhttp.open("POST", "addsubject" + "?name=" + name + "&description=" + description, true);
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextSubject").innerHTML = xhttp.responseText;
            }
        };
        xhttp.send();
    }

</script>


</html>
