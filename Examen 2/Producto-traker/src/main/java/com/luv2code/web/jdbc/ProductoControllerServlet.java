package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/ProductoControllerServlet")
public class ProductoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductoDbUtil productoDbUtil;
	
	@Resource(name="jdbc/web_producto_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			productoDbUtil = new ProductoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listProductos(request, response);
				break;
				
			case "ADD":
				addProducto(request, response);
				break;
				
			case "LOAD":
				loadProducto(request, response);
				break;
				
			case "UPDATE":
				updateStudent(request, response);
				break;
			
			case "DELETE":
				deleteProducto(request, response);
				break;
				
			default:
				listProductos(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteProducto(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theProductoId = request.getParameter("productoId");
		
		// delete student from database
		productoDbUtil.deleteProducto(theProductoId);
		
		// send them back to "list students" page
		listProductos(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("productoId"));
		String nombre = request.getParameter("nombre");
		int precio = Integer.parseInt(request.getParameter("precio"));
		String descripcion = request.getParameter("descripcion");
		
		// create a new student object
		Producto theProducto = new Producto(id, nombre, precio, descripcion);
		
		// perform update on database
		productoDbUtil.updateProducto(theProducto);
		
		// send them back to the "list students" page
		listProductos(request, response);
		
	}

	private void loadProducto(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theProductoId = request.getParameter("productoId");
		
		// get student from database (db util)
		Producto theProducto = productoDbUtil.getProducto(theProductoId);
		
		// place student in the request attribute
		request.setAttribute("THE_PRODUCTO", theProducto);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String descripcion = request.getParameter("descripcion");
		
		int precioInt = Integer.valueOf(precio);
		
		// create a new student object
		Producto theProducto = new Producto(nombre, precioInt, descripcion);
		
		// add the student to the database
		productoDbUtil.addProducto(theProducto);
				
		// send back to main page (the student list)
		listProductos(request, response);
	}

	private void listProductos(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Producto> productos = productoDbUtil.getProductos();
		
		// add students to the request
		request.setAttribute("PRODUCTO_LIST", productos);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-productos.jsp");
		dispatcher.forward(request, response);
	}

}













