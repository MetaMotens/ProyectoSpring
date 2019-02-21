<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="miform"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar Representantes</title>
</head>
<body>
	<h2 align="center">OPERACIONES REPRESENTANTES</h2>
	<br>

	<c:url value="/operacionesrepresentantes" var="url" />

	<miform:form action="${url}" method="post"
		modelAttribute="representante">

		<p>
			Numero representante:
			<miform:input path="numero_rep" type="number" size="5" />
		</p>
		<p>
			Nombre:
			<miform:input path="nombre" type="text" size="5" />
		</p>
		<p>
			Edad:
			<miform:input path="edad" type="number" size="5" />
		</p>

			Oficina:
		<miform:select path="oficina_rep">
			<miform:options items="${listarrepresentantes}" />
		</miform:select>
		
			Director:
		<miform:select path="director">
			<miform:options items="${listardirectores}" />
		</miform:select>
		
		<p>
			Numero ventas:
			<miform:input path="num_ventas" type="number" size="5" />
		</p>
		<p>
			Importe ventas:
			<miform:input path="imp_ventas" type="number" size="5" />
		</p>

		<miform:button name="insertar">Insertar representante</miform:button>
		<miform:button name="borrar">Borrar representante</miform:button>
		<miform:button name="modificar">Modificar representante</miform:button>
		<miform:button name="volver">Volver al index</miform:button>
	</miform:form>

	<h2>${mensaje}</h2>

</body>
</html>