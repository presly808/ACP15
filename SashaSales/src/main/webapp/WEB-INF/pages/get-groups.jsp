<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="ua.artcode.model.Group" %>
<%@ include file="include.jsp" %>
<html>
<head>
    <title>Groups list</title>
</head>

<body>
<div class="container">

    <h3>Group list</h3>

    <table cellspacing="2" border="1" cellpadding="5" width="120">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>

        <c:forEach var="groupIter" items="${grouplistPart}">
            <tr>
                <td>${groupIter.id}</td>
                <td>${groupIter.name}</td>
            </tr>
        </c:forEach>
    </table>


      <br>
        <c:forEach var="i" begin="1" end="${sizePageToSite}">
            <a href="getgroups?page=${i}&size=4" name="${i}">${i}</a>
        </c:forEach>

        <a href="/index.jsp">Back to Main Page</a>


</div>


</body>
</html>
