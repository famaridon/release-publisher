package com.famaridon.rp.server.web.admin.users;

import com.famaridon.rp.server.services.api.bean.dto.UserDto;
import com.famaridon.rp.server.services.api.directory.UserService;
import org.primefaces.model.LazyDataModel;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by famaridon on 19/11/2016.
 */
@ManagedBean(name = "createUserView")
@ViewScoped
public class CreateUserView implements Serializable {
	@EJB
	UserService userService;
	
	private UserDto user = new UserDto();
	
	private LazyDataModel<UserDto> dataModel;
	
	public void create() {
		userService.create(user);
		this.user = new UserDto();
	}
	
	public void cancel() {
		this.user = new UserDto();
	}
	
	/**
	 * get {@link CreateUserView#user} property
	 *
	 * @return get the user property
	 **/
	public UserDto getUser() {
		return user;
	}
	
	/**
	 * set {@link CreateUserView#user} property
	 *
	 * @param user set the user property
	 **/
	public CreateUserView setUser(UserDto user) {
		this.user = user;
		return this;
	}
}
