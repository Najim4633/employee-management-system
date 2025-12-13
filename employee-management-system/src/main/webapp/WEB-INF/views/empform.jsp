<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
	<jsp:include page="header.jsp" />
    <h2>Employee Registration Form</h2>

    <form action="saveemp" method="post">



        <label>Name:</label>
        <input type="text" name="name" required><br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" required><br><br>

        <label>Designation:</label>
        <input type="text" name="designation" required><br><br>

        <label>Address:</label>
        <input type="text" name="address" required><br><br>

        <button type="submit">Submit</button>

    </form>

</body>
</html>
