package com.famaridon.rp.server.services.api.bean.dto;

/**
 * Created by famaridon on 07/04/2017.
 */
public class ProductDto extends AbstractDto {
	private String name;
	
	/**
	 * get {@link ProductDto#name} property
	 *
	 * @return get the name property
	 **/
	public String getName() {
		return name;
	}
	
	/**
	 * set {@link ProductDto#name} property
	 *
	 * @param name set the name property
	 **/
	public void setName(String name) {
		this.name = name;
	}
}
