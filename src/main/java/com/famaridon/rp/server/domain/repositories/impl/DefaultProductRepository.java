package com.famaridon.rp.server.domain.repositories.impl;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.entities.Product;
import com.famaridon.rp.server.domain.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by famaridon on 17/11/2016.
 */
@Repository
public class DefaultProductRepository extends AbstractRepository<Product, Long> implements ProductRepository
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProductRepository.class);
	
}
