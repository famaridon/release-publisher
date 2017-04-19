package com.famaridon.rp.server.services.impl.mapper;

import com.famaridon.rp.server.domain.entities.Product;
import com.famaridon.rp.server.domain.entities.User;
import com.famaridon.rp.server.services.api.bean.dto.ProductDto;
import com.famaridon.rp.server.services.api.bean.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by famaridon on 25/08/2016.
 */
@Mapper
public interface DtoMapper
{
	
	UserDto userToUserDto(User user);
	
	@Mapping(target = "password", ignore = true)
	User userDtoToUser(UserDto user);
	
	ProductDto productToProductDto(Product product);
	Product productDtoToProduct(ProductDto product);
	
}
