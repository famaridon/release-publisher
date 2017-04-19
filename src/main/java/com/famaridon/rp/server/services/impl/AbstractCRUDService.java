package com.famaridon.rp.server.services.impl;

import com.famaridon.rp.server.domain.entities.AbstractEntity;
import com.famaridon.rp.server.domain.repositories.EntityRepository;
import com.famaridon.rp.server.services.api.CRUDService;
import com.famaridon.rp.server.services.api.bean.Pager;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by famaridon on 07/04/2017.
 */
public abstract class AbstractCRUDService<D, E extends AbstractEntity, ID extends Serializable> implements CRUDService<D, ID> {
	
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void create(D dto) {
		E entity = this.toEntity(dto);
		this.getRepository().save(entity);
	}
	
	@Override
	public D read(ID id) {
		return this.toDto(this.getRepository().findOne(id));
	}
	
	@Override
	public Iterable<D> list(Pager pager) {
		return this.toDtos(this.getRepository().findAll(pager));
	}
	
	@Override
	public long count() {
		return this.getRepository().count();
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public D update(D dto) {
		E entity = this.toEntity(dto);
		return this.toDto(this.getRepository().save(entity));
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	@Override
	public void delete(ID id) {
		E entity = this.getRepository().findOne(id);
		if (entity != null) {
			this.getRepository().delete(entity);
		}
	}
	
	protected abstract EntityRepository<E, ID> getRepository();
	
	protected abstract E toEntity(D dto);
	
	protected Iterable<E> toEntities(Iterable<D> dtos){
		List<E> entities = new ArrayList<E>();
		dtos.forEach(dto -> entities.add(this.toEntity(dto)));
		return entities;
	}
	
	protected abstract D toDto(E entity);
	
	protected Iterable<D> toDtos(Iterable<E> entitys) {
		List<D> dtos = new ArrayList<D>();
		entitys.forEach(e -> dtos.add(this.toDto(e)));
		return dtos;
	}
}
