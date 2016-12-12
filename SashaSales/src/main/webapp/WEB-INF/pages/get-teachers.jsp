<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Teacher list</title>
</head>

<div class="container">

    <h3>Teacher list</h3>

    <table cellspacing="2" border="1" cellpadding="5" width="400">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Experience</th>
        </tr>

        <c:forEach var="teacherIter" items="${teacherlist}">
            <tr>
                <td>${teacherIter.id}</td>
                <td>${teacherIter.name}</td>
                <td>${teacherIter.experience}</td>
            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>
