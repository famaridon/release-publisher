package com.famaridon.rp.server.domain.repositories.impl;

import com.famaridon.rp.server.cdi.types.Repository;
import com.famaridon.rp.server.domain.repositories.EntityRepository;
import com.famaridon.rp.server.services.api.bean.Pager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by famaridon on 17/11/2016.
 */
@Repository
public abstract class AbstractRepository<T, ID extends Serializable> implements EntityRepository<T, ID>
{
	private final Class<T> entityClass;
	
	@PersistenceContext(unitName = "release-publisher-persistence-unit")
	protected EntityManager entityManager;
	
	public AbstractRepository()
	{
		entityClass = ((Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	@Override
	public <S extends T> S save(S entity)
	{
		return entityManager.merge(entity);
	}
	
	@Override
	public T findOne(ID primaryKey)
	{
		return entityManager.find(entityClass, primaryKey);
	}
	
	@Override
	public void delete(T entity)
	{
		entityManager.remove(entity);
		entityManager.flush();
	}
	
	@Override
	public boolean exists(ID primaryKey)
	{
		return this.findOne(primaryKey) != null;
	}
	
	@Override
	public Iterable<T> findAll(Pager pager)
	{
		//build the query
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> rootEntry = cq.from(entityClass);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> query = entityManager.createQuery(all);
		
		// set the pager
		query.setFirstResult(pager.getStart());
		query.setMaxResults(pager.getCount());
		
		return query.getResultList();
	}
	
	@Override
	public Long count()
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(entityClass)));
		return entityManager.createQuery(cq).getSingleResult();
	}
	
}
