package com.famaridon.rp.server.domain.repositories.impl;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.entities.User;
import com.famaridon.rp.server.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by famaridon on 17/11/2016.
 */
@Repository
public class DefaultUserRepository extends AbstractRepository<User, Long> implements UserRepository
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserRepository.class);
	
	@Override
	public User findByLogin(String login)
	{
		try
		{
			TypedQuery<User> query = entityManager.createNamedQuery("User.finByLogin", User.class);
			query.setParameter("login", login);
			return query.getSingleResult();
		}
		catch (NoResultException e)
		{
			LOGGER.trace("User not found by it's login {}", login);
		}
		return null;
		
	}
}
