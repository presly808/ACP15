<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Student list</title>
</head>


<c:set var="transfered" value="${studentlist}"/>

<div class="container">

    <h1>Student list</h1>
    <ul>
        <li>
            <div class="column">
                list : ${transfered.toString()}
            </div>
        </li>

    </ul>


        <li><a href="/index.jsp">Back</a></li>


</div>
</body>
</html>
