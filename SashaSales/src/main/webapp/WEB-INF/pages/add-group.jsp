<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Group</title>
</head>
<body>

<div class="left-container">

    <h1>Add Group to DB University</h1>
    <form method="post" action="addgroup">

        <ul>
            <li> Create group:
                <input name="group_name" type="text">
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
