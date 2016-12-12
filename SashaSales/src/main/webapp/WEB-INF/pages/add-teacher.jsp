
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Teacher</title>
</head>
<body>

<div class="container">

    <h3>Add Teacher to DB University</h3>

    <label>Input teacher name:</label>
    <input id="teacher_name" type="text"><br>
    <label>Input experience:</label>
    <input id="experience" type="number">
    <label>Input subject_id:</label>
    <input id="subject_id" type="number">
    <button onclick="sendAjaxReqTeacher()">Send Ajax req</button>
    <div id="responseTextTeacher"></div>

    <a href="/index.jsp">Back</a>


</div>

</body>

<script>


    function sendAjaxReqTeacher() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("teacher_name").value;
        var experience = document.getElementById("experience").value;
        var subject_id = document.getElementById("subject_id").value;

        xhttp.open("POST", "addteacher" + "?name=" + name +
                "&experience=" + experience + "&subject_id=" + subject_id, true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextTeacher").innerHTML = xhttp.responseText;
            }
        };

    }


</script>

</html>
