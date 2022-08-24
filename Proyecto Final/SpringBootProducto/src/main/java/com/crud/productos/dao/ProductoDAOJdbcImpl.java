package com.crud.productos.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.productos.entity.Producto;

@Repository
public class ProductoDAOJdbcImpl implements ProductoDAO {

	@Autowired
	DataSource dataSource;

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	@Override
	public List<Producto> findAll() {
		System.out.println("Implementación DAO con JDBC: "+ dataSource);
		
		List<Producto> listaProductos = new ArrayList<>();
		try(Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from productos"))
		{while (myRs.next()) {
					
			// retrieve data from result set row
			int id = myRs.getInt("id");
			String nombre = myRs.getString("nombre");
			int precio = myRs.getInt("precio");
			String descripcion = myRs.getString("descripcion");
					
			// create new student object
			Producto tempProductos = new Producto(id, nombre, precio, descripcion);
					
			// add it to the list of students
			listaProductos.add(tempProductos);
			}
		}catch (SQLException e) {
		e.printStackTrace();
		}
		return listaProductos;
	}

	@Override
	public Producto findById(int theId) {
		Producto theProduct = null;
		
		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement("select * from productos where id=?")
			){
			myStmt.setInt(1, theId);
			try(ResultSet myRs = myStmt.executeQuery()){

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				int precio = Integer.parseInt(myRs.getString("precio"));
				String descripcion = myRs.getString("descripcion");
			
				// use the studentId during construction
				theProduct = new Producto(theId, nombre, precio, descripcion);
			}}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theProduct;
		}

	@Override
	public void save(Producto theProducto) {
		
			if(theProducto.getId()!=0) try(Connection myConn = dataSource.getConnection()){{
				PreparedStatement myStmt = myConn.prepareStatement("update productos "
						   + "set nombre=?, precio=?, descripcion=? "
						   + "where id=?");
				// set the param values for the student
				
				myStmt.setString(1, theProducto.getNombre());
				myStmt.setInt(2, theProducto.getPrecio());
				myStmt.setString(3, theProducto.getDescripcion());
				myStmt.setInt(4, theProducto.getId());
				
				// execute sql insert
				myStmt.execute();
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}else {
				try(Connection myConn = dataSource.getConnection()){PreparedStatement myStmt = myConn.prepareStatement("insert into productos "
						   + "(nombre, precio, descripcion) "
						   + "values (?, ?, ?)");
				// set the param values for the student
				myStmt.setString(1, theProducto.getNombre());
				myStmt.setInt(2, theProducto.getPrecio());
				myStmt.setString(3, theProducto.getDescripcion());
			
				// execute sql insert
				myStmt.execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
	}

	@Override
	public void deleteById(int theId) {
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement("delete from productos where id=?");
			){
			myStmt.setInt(1, theId);
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}








