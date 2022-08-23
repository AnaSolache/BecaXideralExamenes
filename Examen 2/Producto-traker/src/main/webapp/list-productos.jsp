<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Productos Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Tienda Muebles</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Añadir producto" 
				   onclick="window.location.href='add-producto-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Descripcion</th>
					<th>Accion</th>
				</tr>
				
				<c:forEach var="tempProducto" items="${PRODUCTO_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProductoControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProductoControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempProducto.nombre} </td>
						<td> ${tempProducto.precio} </td>
						<td> ${tempProducto.descripcion} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Estás seguro que quieres eliminar este producto?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








