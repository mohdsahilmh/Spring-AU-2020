<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Employee Form</h1>
 	
	<form:form method="POST" modelAttribute="emp"  class="form-horizontal" action="save">
	
         <div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="id">ID</label>
				<div class="col-md-7">
					<form:input type="text" path="id" id="id" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="id" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
         
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="firstname">First Name</label>
				<div class="col-md-7">
					<form:input type="text" path="firstname" id="firstname" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="firstname" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lastname">Last Name</label>
				<div class="col-md-7">
					<form:input type="text" path="lastname" id="lastname" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="lastname" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="phno">phno</label>
				<div class="col-md-7">
					<form:input type="text" path="phno" id="phno" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="phno" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>