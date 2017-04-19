package com.famaridon.rp.server.domain.repositories;

import com.famaridon.rp.server.services.api.bean.Pager;

import java.io.Serializable;

/**
 * Created by famaridon on 17/11/2016.
 */
public interface EntityRepository<T, ID extends Serializable>
{
	<S extends T> S save(S entity);
	
	T findOne(ID primaryKey);
	
	Iterable<T> findAll(Pager pager);
	
	Long count();
	
	void delete(T entity);
	
	boolean exists(ID primaryKey);
}
