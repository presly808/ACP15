<%@ include file="WEB-INF/pages/include.jsp" %>
<html>
<head>
    <title>Main</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
          crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>


</head>
<body>

<div class="header">
</div>

<div class="addgroup-container">

    <h3>Add Group to DB University</h3>

    <label>Input group name:</label>
    <input id="group_name" type="text"><br>
    <button onclick="sendAjaxReqGroup()">Send Ajax req</button>
    <div id="responseTextGroup"></div>

</div>

<div class="addstudent-container">

    <h3>Add Student to DB University</h3>

    <label>Create student:</label>
    <input id="student_name" type="text"><br>
    <button onclick="sendAjaxReqStudent()">Send Ajax req</button>
    <div id="responseTextStudent"></div>

</div>

<div class="addsubject-container">

    <h3>Add Subject to DB University</h3>

    <label>Input subject name:</label>
    <input id="subject_name" type="text"><br>
    <label>Input subject description:</label>
    <input id="subject_description" type="text">
    <button onclick="sendAjaxReqSubject()">Send Ajax req</button>
    <div id="responseTextSubject"></div>

</div>

<div class="addteacher-container">

    <h3>Add Teacher to DB University</h3>

    <label>Input teacher name:</label>
    <input id="teacher_name" type="text"><br>
    <label>Input experience:</label>
    <input id="experience" type="number">
    <label>Input subject_id:</label>
    <input id="subject_id" type="number">
    <button onclick="sendAjaxReqTeacher()">Send Ajax req</button>
    <div id="responseTextTeacher"></div>

</div>

<div id="responseGroupList" class="getgroup-container" onclick="sendAjaxReqGetGroups()">
    <h3>Press to show Group list>></h3>
</div>

<div id="responseStudentList" class="getstudent-container" onclick="sendAjaxReqGetStudents()">
    <h3>Press to show Student list>></h3>
</div>

<div id="responseSubjectList" class="getsubject-container" onclick="sendAjaxReqGetSubjects()">
    <h3>Press to show Subject list>></h3>
</div>

<div id="responseTeacherList" class="getteacher-container" onclick="sendAjaxReqGetTeachers()">
    <h3>Press to show Subject list>></h3>
</div>

<script>

    function sendAjaxReqGroup() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("group_name").value;
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextGroup").innerHTML = xhttp.responseText;
            }
        };

        xhttp.open("POST", "addgroup" + "?name=" + name, true);
        xhttp.send();

    }

    function sendAjaxReqStudent() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("student_name").value;
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextStudent").innerHTML = xhttp.responseText;
            }
        };

        xhttp.open("POST", "addstudent" + "?name=" + name, true);
        xhttp.send();

    }

    function sendAjaxReqSubject() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("subject_name").value;
        var description = document.getElementById("subject_description").value;
        xhttp.open("POST", "addsubject" + "?name=" + name + "&description=" + description, true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextSubject").innerHTML = xhttp.responseText;
            }
        };

    }

    function sendAjaxReqTeacher() {

        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("teacher_name").value;
        var experience = document.getElementById("experience").value;
        var subject_id = document.getElementById("subject_id").value;
        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200) {
                document.getElementById("responseTextTeacher").innerHTML = xhttp.responseText;
            }
        };

        xhttp.open("POST", "addteacher" + "?name=" + name +
                "&experience=" + experience + "&subject_id=" + subject_id, true);
        xhttp.send();

    }


    function sendAjaxReqGetGroups() {

        var xhttp = new XMLHttpRequest();

        xhttp.open("GET", "getgroups?page=1&size=30", true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseGroupList").innerHTML = xhttp.responseText;
            }
        };

    }

    function sendAjaxReqGetStudents() {

        var xhttp = new XMLHttpRequest();

        xhttp.open("GET", "getstudents", true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseStudentList").innerHTML = xhttp.responseText;
            }
        };

    }

    function sendAjaxReqGetSubjects() {

        var xhttp = new XMLHttpRequest();

        xhttp.open("GET", "getsubjects", true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseSubjectList").innerHTML = xhttp.responseText;
            }
        };
    }

    function sendAjaxReqGetTeachers() {

        var xhttp = new XMLHttpRequest();

        xhttp.open("GET", "getteachers", true);
        xhttp.send();

        xhttp.onreadystatechange = function () {
            console.log(xhttp.readyState);
            if (xhttp.readyState === 4 && xhttp.status === 200){
                document.getElementById("responseTeacherList").innerHTML = xhttp.responseText;
            }
        };
    }

</script>


</body>

<style type="text/css">
    .addgroup-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #2135ff;
        top: 10px;
        left: 10px;
    }

    .addstudent-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #2bdfff;
        top: 10px;
        left: 310px;
    }

    .addsubject-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #ff100e;
        top: 10px;
        left: 610px;
    }

    .addteacher-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #24ffe7;
        top: 10px;
        left: 910px;
    }

    .getgroup-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #24ffe7;
        top: 250px;
        left: 10px;
    }

    .getstudent-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #24ffe7;
        top: 250px;
        left: 310px;
    }

    .getsubject-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #24ffe7;
        top: 250px;
        left: 610px;
    }

    .getteacher-container {
        width: 300px;
        height: 300px;
        position: absolute;
        color: #24ffe7;
        top: 250px;
        left: 910px;
    }

</style>


</html>
