<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Tienda de muebles</title>
	
	<!-- referencia a nuestra style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Lista de productos disponibles</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Añadir Producto"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Precio</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProducto" items="${producto}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/producto/showFormForUpdate">
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/producto/delete">
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProducto.Nombre} </td>
						<td> ${tempProducto.Descripcion} </td>
						<td> ${tempProducto.Precio} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Estás seguro de que deseas borrar el producto?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









