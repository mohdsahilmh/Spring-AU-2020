<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<h1 align="center">Students List</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/springexample/enroll"><h2>Home Page:Enroll New Employee</h2></a>

</th>

<th>

<a  align ="right" href="/delete"><h2>Delete All Employee</h2></a>
</th>
</tr>
</table>

<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>First Name</th><th>Last Name</th>
<th>phno</th>
   <c:forEach var="student" items="${list}"> 
   <tr>  
   <td>${student.id}</td>  
   <td>${student.firstname}</td> 
   <td>${student.lastname}</td>  
   <td>${student.phno}</td>  
   <td><a href="/springexample/editstudent/${student.id}">Edit</a></td>  
   <td><a href="/springexample/deletestudent/${student.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>