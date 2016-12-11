<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Subject list</title>
</head>


<c:set var="transfered" value="${subjectlist}"/>

<div class="container">

    <h1>Subject list</h1>
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
