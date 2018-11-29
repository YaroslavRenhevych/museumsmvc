<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Visitor Details</h3>
        <form:form method="POST"
          action="/museumsmvc/app/visitors/create" modelAttribute="visitor">
             <table>
                <tr>
                    <td><form:label path="firstName">firstName:</form:label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">lastName:</form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">email:</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="phone">phone:</form:label></td>
                    <td><form:input path="phone"/></td>
                </tr>
                <tr>
                	<td><form:label path="birthDate">Date of Birth:</form:label></td>
                    <td><form:input type="date" path="birthDate" /></td>
                </tr>
                <tr>
			        <td>Museums:</td>
			        <td>
				        <form:checkboxes path="museums" items="${museumList}" itemValue="id" itemLabel="title"/>
		        	</td>
			    </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>