<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Producto Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Producto> theProductos = 
					(List<Producto>) request.getAttribute("PRODUCTO_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Tienda de muebles</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Descripcion</th>
				</tr>
				
				<% for (Producto tempProducto : theProductos) { %>
				
					<tr>
						<td> <%= tempProducto.getNombre() %> </td>
						<td> <%= tempProducto.getPrecio() %> </td>
						<td> <%= tempProducto.getDescripcion() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








