<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.project.empcrud.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>

    <%@ include file="header.jsp" %>

    <h2>Employee List</h2>

	<%
	    // get list from model
	    List<Employee> list = (List<Employee>) request.getAttribute("employees");
	%>


    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Designation</th>
            <th>Address</th>
			<th>Delete</th>
			<th>Update</th>
        </tr>

        <%
            if (list != null) {
                for (Employee emp : list) {
        %>
                    <tr>
						
						
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getName() %></td>
                        
                        <td><%= emp.getSalary() %></td>
                        <td><%= emp.getDesignation() %></td>
                        <td><%= emp.getAddress() %></td>
						<td><a href="deleteemp?id=<%= emp.getId() %>">Delete</a></td>
						<td><a href="updateemp?id=<%= emp.getId() %>">Update</a></td>
                    </tr>
					
        <%
                }
            }
        %>

    </table>
    <h3>${page +1}/${totalpage}   </h3> 

<%@ include file="footer.jsp" %>
</body>
</html>
