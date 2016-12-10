<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Group info</title>
</head>


<c:set var="transfered" value="${group}"/>

<div class="container">

    <h1>Created group</h1>
    <ul>
        <li>
            <div class="column">
                id : ${transfered.getId()}
            </div>
        </li>

        <li>
            <div class="column">
                name : ${transfered.getName()}
            </div>
        </li>


    </ul>
</div>
</body>
</html>