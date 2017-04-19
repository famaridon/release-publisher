package com.famaridon.rp.server.services.api;

import com.famaridon.rp.server.services.api.bean.Pager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.Serializable;

/**
 * Created by famaridon on 19/11/2016.
 */
@Api
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface CRUDService<T, ID extends Serializable>
{
	@Path("/")
	@ApiOperation(value="create object")
	@POST
	public void create(T dto);
	
	@Path("/{id}")
	@ApiOperation(value="read object")
	@GET
	public T read(@PathParam("id") ID id);
	
	public Iterable<T> list(Pager pager);
	
	public long count();
	
	public T update(T dto);
	
	public void delete(ID id);
}
