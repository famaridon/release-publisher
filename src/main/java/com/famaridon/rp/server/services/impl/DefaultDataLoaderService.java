package com.famaridon.rp.server.services.impl;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.entities.Product;
import com.famaridon.rp.server.domain.entities.User;
import com.famaridon.rp.server.domain.repositories.ProductRepository;
import com.famaridon.rp.server.domain.repositories.UserRepository;
import com.famaridon.rp.server.interceptors.binding.Logged;
import com.famaridon.rp.server.services.api.bean.Pager;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

/**
 * Created by famaridon on 19/11/2016.
 */
@Startup
@Singleton
@Logged
public class DefaultDataLoaderService {
	
	@Inject
	@Repository
	UserRepository userRepository;
	
	@Inject
	@Repository
	ProductRepository productRepository;
	
	@PostConstruct
	@Transactional(Transactional.TxType.REQUIRED)
	public void init() {
		createUser("sysadmin", "System", "Administrator");
		createUser("famaridon", "Florent", "Amaridon");
		createUser("wtoscer", "Willy", "Toscer");
		createUser("flucas", "Florian", "Lucas");
		createUser("omassol", "Olivier", "Massol");
		createUser("fpicot", "Florent", "Picot");
		
		this.cleanProducts();
		
		createProduct("moovapps-process");
		createProduct("moovapps-community");
		createProduct("moovapps-ged");
	}
	
	private void createUser(String login, String firstName, String lastName) {
		User user = this.userRepository.findByLogin(login);
		if (user == null) {
			user = new User();
			user.setLogin(login);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword("manager");
			this.userRepository.save(user);
		}
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	private void cleanProducts() {
		Iterable<Product> productList = this.productRepository.findAll(new Pager(0,10));
		productList.forEach(p -> this.productRepository.delete(p));
	}
	
	private void createProduct(String name) {
		try {
			Product product = new Product();
			product.setName(name);
			this.productRepository.save(product);
		}
		catch (ConstraintViolationException e) {
			// it's ok continue
		}
	}
}
