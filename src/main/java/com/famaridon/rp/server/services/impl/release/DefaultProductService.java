package com.famaridon.rp.server.services.impl.release;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.entities.Product;
import com.famaridon.rp.server.domain.repositories.EntityRepository;
import com.famaridon.rp.server.domain.repositories.ProductRepository;
import com.famaridon.rp.server.interceptors.binding.Logged;
import com.famaridon.rp.server.services.api.bean.dto.ProductDto;
import com.famaridon.rp.server.services.api.release.ProductService;
import com.famaridon.rp.server.services.impl.AbstractCRUDService;
import com.famaridon.rp.server.services.impl.mapper.DtoMapper;
import io.swagger.annotations.Api;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Created by famaridon on 07/04/2017.
 */
@Logged
@Stateless
@Api(value="/product")
@Path("/product")
public class DefaultProductService extends AbstractCRUDService<ProductDto, Product, Long> implements ProductService {
	
	@Inject
	@Repository
	ProductRepository repository;
	
	@Inject
	DtoMapper dtoMapper;
	
	@Override
	protected EntityRepository<Product, Long> getRepository() {
		return this.repository;
	}
	
	@Override
	protected Product toEntity(ProductDto dto) {
		return this.dtoMapper.productDtoToProduct(dto);
	}
	
	@Override
	protected ProductDto toDto(Product entity) {
		return this.dtoMapper.productToProductDto(entity);
	}
	
}
