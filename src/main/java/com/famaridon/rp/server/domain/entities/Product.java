package com.famaridon.rp.server.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class Product extends AbstractEntity {
	@Column(unique = true, nullable = false)
	private String name;
	
	@OneToMany
	private Set<Version> versions = new HashSet<>();
	
	/**
	 * get {@link Product#name} property
	 *
	 * @return get the name property
	 **/
	public String getName() {
		return name;
	}
	
	/**
	 * set {@link Product#name} property
	 *
	 * @param name set the name property
	 **/
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("name", name).toString();
	}
}
