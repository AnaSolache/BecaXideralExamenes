<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Producto</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Tienda de Muebles</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar Producto</h3>
		
		<form action="ProductoControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="productoId" value="${THE_PRODUCTO.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_PRODUCTO.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Precio:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_PRODUCTO.precio}" /></td>
					</tr>

					<tr>
						<td><label>Descripcion:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_PRODUCTO.descripcion}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="ProductoontrollerServlet">Regresar a lista</a>
		</p>
	</div>
</body>

</html>











