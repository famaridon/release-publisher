package com.famaridon.rp.server.domain.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
@NamedQueries({
	@NamedQuery(name= "User.finByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
})
public class User extends AbstractEntity
{
	@Column(unique = true, nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column
	private String password;
	
	/**
	 * get {@link User#login} property
	 *
	 * @return get the login property
	 **/
	public String getLogin()
	{
		return login;
	}
	
	/**
	 * set {@link User#login} property
	 *
	 * @param login set the login property
	 **/
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	/**
	 * get {@link User#password} property
	 *
	 * @return get the password property
	 **/
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}
	
	/**
	 * set {@link User#password} property
	 *
	 * @param password set the password property
	 **/
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * get {@link User#firstName} property
	 *
	 * @return get the firstName property
	 **/
	public String getFirstName()
	{
		return firstName;
	}
	
	public User setFirstName(String firstName)
	{
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * get {@link User#lastName} property
	 *
	 * @return get the LastName property
	 **/
	public String getLastName()
	{
		return lastName;
	}
	
	public User setLastName(String lastName)
	{
		this.lastName = lastName;
		return this;
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
		
		User user = (User)o;
		
		return new EqualsBuilder().appendSuper(super.equals(o)).append(login, user.login).isEquals();
	}
	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(login).toHashCode();
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("login", login).toString();
	}
}
