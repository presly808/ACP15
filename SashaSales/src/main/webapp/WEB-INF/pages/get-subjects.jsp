<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Subject list</title>
</head>

<div class="container">

    <h3>Subject list</h3>

    <table cellspacing="2" border="1" cellpadding="5" width="200">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>

        <c:forEach var="subjectIter" items="${subjectlist}">
            <tr>
                <td>${subjectIter.id}</td>
                <td>${subjectIter.name}</td>
                <td>${subjectIter.description}</td>
            </tr>
        </c:forEach>
    </table>


</div>
</body>
</html>
