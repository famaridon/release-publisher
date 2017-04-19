package com.famaridon.rp.server.web.admin.users;

import com.famaridon.rp.server.services.api.CRUDService;
import com.famaridon.rp.server.services.api.bean.Pager;
import com.famaridon.rp.server.services.api.bean.dto.AbstractDto;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by famaridon on 19/11/2016.
 */
public class LazyDtoDataModel<T extends AbstractDto> extends LazyDataModel<T> {
	private final CRUDService<T, Long> service;
	
	public LazyDtoDataModel(CRUDService<T, Long> service) {
		this.service = service;
	}
	
	@Override
	public T getRowData(String rowKey) {
		return this.service.read(Long.parseLong(rowKey));
	}
	
	@Override
	public Object getRowKey(T dto) {
		return dto.getId();
	}
	
	@Override
	public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		Pager pager = new Pager(first, pageSize);
		
		// count any time we can have new items from other user
		this.setRowCount(Math.toIntExact(this.service.count()));
		
		List<T> result = new ArrayList<T>();
		this.service.list(pager).forEach(e -> result.add(e));
		return result;
	}
}
