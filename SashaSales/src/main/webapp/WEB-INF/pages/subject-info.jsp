<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Subject info</title>
</head>


<c:set var="transfered" value="${subject}"/>

<div class="container">

    <h3>Created subject</h3>
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
        <li>
            <div class="column">
                description : ${transfered.getDescription()}
            </div>
        </li>

    </ul>
</div>
</body>
</html>