<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
	<%@ include file="header.jsp" %>
    <h2>Employee Registration Form</h2>

    <form action="updatedemp" method="post">


		<label>Id:</label>
		<input type="hidden" name="id" value =${emp.id}> ${emp.id}<br><br>
		
        <label>Name:</label>
        <input type="text" name="name" value =${emp.name}><br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" value =${emp.salary}><br><br>

        <label>Designation:</label>
        <input type="text" name="designation" value =${emp.designation}><br><br>

        <label>Address:</label>
        <input type="text" name="address" value =${emp.address}><br><br>

        <button type="submit">Submit</button>

    </form>


</body>
</html>
