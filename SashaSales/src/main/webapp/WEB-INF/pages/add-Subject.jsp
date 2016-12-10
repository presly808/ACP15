
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Subject</title>
</head>
<body>

<div class="container">

    <h1>Add Subject to DB University</h1>
    <form method="post" action="addsubject">

        <ul>
            <li> Subject name:
                <input name="subject_name" type="text">
            </li>
            <li> Subject description:
                <input name="subject_description" type="text">
            </li>
            <li> Submit:
                <input type="submit">
            </li>
        </ul>

    </form>

</div>


</body>
</html>
