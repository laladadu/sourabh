<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form:form method="POST" action="userSignIn.do"  modelAttribute="AdminLogin" >
        <table width="100%" border="0">
          <tr>
	            <td>
	            <label>Email Id:</label>
	            </td>
	            <td>
	            <form:input path="email_id" id="email_id" /> 
	            </td>
          </tr>
          <tr>
	            <td><label>  Password :  </label>
	            </td>
	            <td>
	            <form:password path="password" id="password" />
	            </td>
          </tr>
          
          <tr>
            <td colspan="2"><input type="submit" value="Submit" />
            </td>
          </tr>
        </table>
      </form:form>
</body>
</html>