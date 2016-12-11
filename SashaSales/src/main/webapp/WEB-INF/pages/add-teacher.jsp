
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Teacher</title>
</head>
<body>

<div class="container">

    <h1>Add Teacher to DB University</h1>
    <form method="post" action="addteacher">

        <ul>
            <li> Teacher name:
                <input name="teacher_name" type="text">
            </li>
            <li> Teacher experience:
                <input name="experience" type="number">
            </li>
            <li> Subject id from DB:
                <input name="subject_id" type="number">
            </li>
            <li> Submit:
                <input type="submit">
            </li>
        </ul>

    </form>

    <a href="/index.jsp">Back</a>

</div>


</body>
</html>
