package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Employee;
import com.client.rest.model.Producto;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Producto> getProductos() {
		
		logger.info("***OBTENER LISTA DE PRODUCTOS DESDE EL SERVICE REST PRODUCTO");
		logger.info("in getProductos(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Producto>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Producto>>() {});

		// get the list of customers from response
		List<Producto> productos = responseEntity.getBody();

		logger.info("in getProductos(): productos" + productos);
		
		return productos;
	}

	@Override
	public Producto getProducto(int theId) {
		logger.info("***OBTENER UN PRODUCTO DESDE EL SERVICE REST PRODUCTO");

		logger.info("in getProducto(): Calling REST API " + crmRestUrl);

		// make REST call
		Producto theProducto = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Producto.class);

		logger.info("in saveProducto(): theProducto=" + theProducto);
		
		return theProducto;
	}

	@Override
	public void saveProducto(Producto theProducto) {

		logger.info("in saveProducto(): Calling REST API " + crmRestUrl);
		
		int productoId = theProducto.getId();

		// make REST call
		if (productoId == 0) {
			// add employee
			logger.info("***SALVAR UN PRODUCTO DESDE EL SERVICE REST PRODUCTO");

			restTemplate.postForEntity(crmRestUrl, theProducto, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN PRODUCTO DESDE EL SERVICE REST PRODUCTO");

			restTemplate.put(crmRestUrl, theProducto);
		}

		logger.info("in saveProducto(): success");	
	}

	@Override
	public void deleteProducto(int theId) {
		logger.info("***BORRAR UN PRODUCTO DESDE EL SERVICE REST PRODUCTO");

		logger.info("in deleteProducto(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteProducto(): deleted producto theId=" + theId);
	}

}
