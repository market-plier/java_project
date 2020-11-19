    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Person List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>First name</th><th>Last name</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="per" items="${list}">
    <tr>
    <td>${per.id}</td>
    <td>${per.firstName}</td>
    <td>${per.lastName}</td>
    <td><a href="editperson/${per.id}">Edit</a></td>
    <td><a href="deleteperson/${per.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="personform">Add New Person</a>