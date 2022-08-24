<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Producto</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/producto-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Tienda de muebles</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Productos</h3>
	
		<form:form action="saveProducto" modelAttribute="producto" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Descripción:</label></td>
						<td><form:input path="descripcion" /></td>
					</tr>

					<tr>
						<td><label>Precio:</label></td>
						<td><form:input path="precio" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/producto/lista">Volver a lista</a>
		</p>
	
	</div>

</body>

</html>










