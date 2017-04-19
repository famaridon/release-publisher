package com.famaridon.rp.server.web.admin.users;

import com.famaridon.rp.server.services.api.bean.dto.UserDto;
import com.famaridon.rp.server.services.api.directory.UserService;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by famaridon on 19/11/2016.
 */
@ManagedBean(name = "userView")
@ViewScoped
public class UserListView implements Serializable
{
	@EJB
	UserService userService;
	
	private LazyDataModel<UserDto> dataModel;
	
	@PostConstruct
	public void init() {
		this.dataModel = new LazyDtoDataModel<>(this.userService);
	}
	
	public LazyDataModel<UserDto> getDataModel()
	{
		return this.dataModel;
	}
}
