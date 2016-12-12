<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp"%>
<html>
<head>
    <title>Student list</title>
</head>

<div class="container">

    <h3>Student list</h3>

    <table cellspacing="2" border="1" cellpadding="5" width="200">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        <c:forEach var="studentIter" items="${studentlist}">
            <tr>
                <td>${studentIter.id}</td>
                <td>${studentIter.name}</td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
