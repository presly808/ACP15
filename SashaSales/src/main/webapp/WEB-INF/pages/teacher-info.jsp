<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Teacher info</title>
</head>


<c:set var="transfered" value="${teacher}"/>

<div class="container">

    <h3>Created teacher</h3>
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
                Experience : ${transfered.getExperience()}
            </div>
        </li>
        <li>
            <div class="column">
                Subject : ${transfered.getSubject()}
            </div>

        </li>

    </ul>
</div>
</body>
</html>
