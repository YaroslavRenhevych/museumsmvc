<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Painter Details</h3>
        <form:form method="POST"
          action="/museumsmvc/app/painters/create" modelAttribute="painter">
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
                    <td><form:label path="country">country:</form:label></td>
                    <td><form:input path="country"/></td>
                </tr>
                <tr>
                	<td><form:label path="birthDate">Date of Birth:</form:label></td>
                    <td><form:input type="date" path="birthDate" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>