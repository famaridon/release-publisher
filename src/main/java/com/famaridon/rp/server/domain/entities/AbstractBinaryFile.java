package com.famaridon.rp.server.domain.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by famaridon on 23/05/2016.
 */
@MappedSuperclass
public abstract class AbstractBinaryFile extends AbstractEntity {
	@Column(nullable = false)
	private String file;
	@Column
	private String md5;
	@Column
	private String sha1;
	
}
