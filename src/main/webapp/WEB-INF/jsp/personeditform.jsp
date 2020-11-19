<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<h1>Edit Person</h1>
       <form:form method="post" action="editsave">
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:input  path="id" /></td>
         </tr> 
         <tr>  
          <td>First Name : </td>
          <td><form:input path="firstName"  /></td>
         </tr>  
         <tr>  
          <td>Last Name :</td>
          <td><form:input path="lastName" /></td>
         </tr>
            <tr>
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
