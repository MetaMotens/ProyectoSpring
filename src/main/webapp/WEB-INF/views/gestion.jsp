<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="miform"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Gestionar Representantes</title>
</head>
<body class="container text-center">
	<h2 class="mt-4">OPERACIONES REPRESENTANTES</h2>


	<c:url value="/operacionesrepresentantes" var="url" />

	<miform:form action="${url}" method="post"
		modelAttribute="representante">

		<div class="form-group">
			<label for="nombre">Nombre</label>
			<miform:input path="nombre" type="text" class="form-control"
				id="nombre" />
		</div>

		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="numero">Numero representante</label>
				<miform:input path="numero_rep" type="number" class="form-control"
					id="numero" />
			</div>
			<div class="form-group col-md-6">
				<label for="edad">Edad</label>
				<miform:input path="edad" type="number" class="form-control"
					id="edad" />
			</div>
		</div>


		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="oficina">Oficina</label>
				<miform:select path="oficina_rep" class="form-control" id="oficina">
					<miform:options items="${directoresMap}" />
				</miform:select>
			</div>
			<div class="form-group col-md-6">
				<label for="director">Director</label>
				<miform:select path="director" class="form-control" id="director">
					<miform:options items="${oficinasMap}" />
				</miform:select>
			</div>
		</div>


		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="numeroventas">Numero ventas</label>
				<miform:input path="num_ventas" type="number" class="form-control"
					id="numeroventas" />
			</div>
			<div class="form-group col-md-6">
				<label for="importeventas">Importe ventas</label>
				<miform:input path="imp_ventas" type="number" class="form-control"
					id="importeventas" />
			</div>
		</div>



		<miform:button class="btn btn-primary" name="insertar">Insertar</miform:button>
		<miform:button class="btn btn-primary" name="borrar">Borrar</miform:button>
		<miform:button class="btn btn-primary" name="modificar">Modificar</miform:button>
		<miform:button class="btn btn-danger" name="volver">Volver</miform:button>
	</miform:form>

	<h2>${mensaje}</h2>


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