<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
    <head>
		<style type="text/css">
		   .isa_info, .isa_success, .isa_warning, .isa_error {
			margin: 10px 0px;
			padding:2px;
			 
			}
			.isa_info {
			    color: #00529B;
			    background-color: #BDE5F8;
			}
			.isa_success {
			    color: #4F8A10;
			    background-color: #DFF2BF;
			}
			.isa_warning {
			    color: #9F6000;
			    background-color: #FEEFB3;
			}
			.isa_error {
			    color: #D8000C;
			    background-color: #FFD2D2;
			}
			.isa_info i, .isa_success i, .isa_warning i, .isa_error i {
			    margin:10px 22px;
			    font-size:2em;
			    vertical-align:middle;
			}
		</style>
    </head>
    <body>
        <h3>Welcome, Enter The Museum Details</h3>
        
        <c:if test = "${success_message != null}">
        	<div class="isa_success">
			<i class="fa fa-check"></i>${success_message}
		</div>
      	</c:if>
		
        <form:form method="POST"
          action="/museumsmvc/app/museums/create" modelAttribute="museum">
             <table>
                <tr>
                    <td><form:label path="title">Title:</form:label></td>
                    <td><form:input path="title"/></td>
                    <td><form:errors path="title" cssClass="isa_error" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Address:</form:label></td>
                    <td><form:input path="address"/></td>
                    <td><form:errors path="address" cssClass="isa_error" /></td>
                </tr>
                <tr>
                    <td><form:label path="phone">Phone:</form:label></td>
                    <td><form:input path="phone"/></td>
                    <td><form:errors path="phone" cssClass="isa_error" /></td>
                </tr>
                <tr>
                    <td><form:label path="site">Web-site:</form:label></td>
                    <td><form:input path="site"/></td>
                    <td><form:errors path="site" cssClass="isa_error" /></td>
                </tr>
                <tr>
                	<td><form:label path="foundingDate">Founding date:</form:label></td>
                    <td><form:input path="foundingDate" type="date"/></td>
                    <td><form:errors path="foundingDate" cssClass="isa_error" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>