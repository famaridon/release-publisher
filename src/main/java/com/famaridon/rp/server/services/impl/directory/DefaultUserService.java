package com.famaridon.rp.server.services.impl.directory;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.entities.User;
import com.famaridon.rp.server.domain.repositories.EntityRepository;
import com.famaridon.rp.server.domain.repositories.UserRepository;
import com.famaridon.rp.server.interceptors.binding.Logged;
import com.famaridon.rp.server.services.api.directory.UserService;
import com.famaridon.rp.server.services.api.bean.dto.UserDto;
import com.famaridon.rp.server.services.impl.AbstractCRUDService;
import com.famaridon.rp.server.services.impl.mapper.DtoMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by famaridon on 22/08/2016.
 */
@Logged
@Stateless
public class DefaultUserService extends AbstractCRUDService<UserDto, User, Long> implements UserService
{
	
	@Inject
	@Repository
	UserRepository repository;
	
	@Inject
	DtoMapper dtoMapper;
	
	@Override
	protected EntityRepository<User, Long> getRepository() {
		return this.repository;
	}
	
	@Override
	protected User toEntity(UserDto dto) {
		return this.dtoMapper.userDtoToUser(dto);
	}
	
	@Override
	protected UserDto toDto(User entity) {
		return this.dtoMapper.userToUserDto(entity);
	}
}
