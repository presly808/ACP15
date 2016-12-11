<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Teacher list</title>
</head>


<c:set var="transfered" value="${teacherlist}"/>

<div class="container">

    <h1>Teacher list</h1>
    <ul>
        <li>
            <div class="column">
                list : ${transfered.toString()}
            </div>
        </li>

    </ul>


    <a href="/index.jsp">Back</a>

</div>


</body>
</html>
