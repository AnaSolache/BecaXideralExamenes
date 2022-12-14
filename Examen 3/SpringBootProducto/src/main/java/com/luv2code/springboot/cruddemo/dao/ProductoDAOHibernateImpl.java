package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.cruddemo.entity.Producto;

@Repository
public class ProductoDAOHibernateImpl implements ProductoDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public ProductoDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Producto> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Producto> theQuery =
				currentSession.createQuery("from Producto", Producto.class);
		
		// execute query and get result list
		List<Producto> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}


	@Override
	public Producto findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Producto theProducto =
				currentSession.get(Producto.class, theId);
		
		// return the employee
		return theProducto;
	}


	@Override
	public void save(Producto theProducto) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theProducto);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Producto where id=:productoId");
		theQuery.setParameter("productoId", theId);
		
		theQuery.executeUpdate();
	}
	
}







