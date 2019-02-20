<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar regiones</title>
</head>
<body>
<h2 align="center">Listar regiones</h2>
	<br>
	<form:form action="volver" method="GET">

		<table border=1>
			<tr>
				<th>COD-REGION</th>
				<th>NOMBRE REGION</th>
				<th>NUMERO OFICINAS</th>
				<th>TOTAL VENTAS</th>
			</tr>
			<c:forEach items="${listarregiones}" var="obj">
				<tr><td><c:out value="${obj.getCod_region()}" /></td>
				   <td><c:out value="${obj.getNombre_re()}" /></td>
				   <td><c:out value="${obj.getNum_oficinas()}" /></td>
				   <td><c:out value="${obj.getTotal_ventas()}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" value="Volver" />
	</form:form>
</body>
</html>