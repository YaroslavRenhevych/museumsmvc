<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Picture Details</h3>
        <form:form method="POST"
          action="/museumsmvc/app/pictures/create" modelAttribute="picture">
             <table>
                <tr>
                    <td><form:label path="title">title:</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                	<td><form:label path="creationDate">Date of creating:</form:label></td>
                    <td><form:input type="date" path="creationDate" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>