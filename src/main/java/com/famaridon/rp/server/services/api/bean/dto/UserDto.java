package com.famaridon.rp.server.services.api.bean.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by famaridon on 25/08/2016.
 */
public class UserDto extends AbstractDto
{
	private String login;
	private String firstName;
	private String lastName;
	
	/**
	 * get {@link UserDto#login} property
	 *
	 * @return get the login property
	 **/
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	/**
	 * get {@link UserDto#firstName} property
	 *
	 * @return get the firstName property
	 **/
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * get {@link UserDto#lastName} property
	 *
	 * @return get the lastName property
	 **/
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		
		UserDto userDto = (UserDto)o;
		
		return new EqualsBuilder().append(login, userDto.login).isEquals();
	}
	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder(17, 37).append(login).toHashCode();
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("login", login).toString();
	}
}
