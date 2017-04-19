package com.famaridon.rp.server.domain.repositories;

import com.famaridon.rp.server.domain.entities.User;

/**
 * Created by famaridon on 23/05/2016.
 */
public interface UserRepository extends EntityRepository<User, Long>
{
	public User findByLogin(String login);
}
