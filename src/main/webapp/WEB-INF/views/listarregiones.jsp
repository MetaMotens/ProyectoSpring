<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Listar regiones</title>
</head>
<body class="container text-center">
	<h2 class="mt-4">Listar regiones</h2><br>

	<form:form action="volver" method="GET">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">COD-REGION</th>
					<th scope="col">NOMBRE REGION</th>
					<th scope="col">NUMERO OFICINAS</th>
					<th scope="col">TOTAL VENTAS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listarregiones}" var="obj">
					<tr>
						<th scope="row"><c:out value="${obj.getCod_region()}" /></th>
						<td><c:out value="${obj.getNombre_re()}" /></td>
						<td><c:out value="${obj.getNum_oficinas()}" /></td>
						<td><c:out value="${obj.getTotal_ventas()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	

		<button type="submit" class="btn btn-danger text-center" value="Volver">Volver</button>
	</form:form>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>





