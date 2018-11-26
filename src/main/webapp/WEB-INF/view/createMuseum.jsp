<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Museum Details</h3>
        <form:form method="POST"
          action="/museumsmvc/app/museums/create" modelAttribute="museum">
             <table>
                <tr>
                    <td><form:label path="title">Title:</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="address">address</form:label></td>
                    <td><form:input path="address"/></td>
                </tr>
                <tr>
                    <td><form:label path="phone">phone</form:label></td>
                    <td><form:input path="phone"/></td>
                </tr>
                <tr>
                    <td><form:label path="site">site</form:label></td>
                    <td><form:input path="site"/></td>
                </tr>
                <%-- <tr>
                    <td><form:label path="foundingDate">date:</form:label></td>
                    <form:input type="date" path="foundingDate" />
                </tr> --%>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>