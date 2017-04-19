package com.famaridon.rp.server.services.api.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by famaridon on 17/11/2016.
 */
public class Pager
{
	private final int start;
	private final int count;
	
	public Pager(int start, int count)
	{
		this.start = start;
		this.count = count;
	}
	
	/**
	 * get {@link Pager#start} property
	 *
	 * @return get the start property
	 **/
	public int getStart()
	{
		return start;
	}
	
	/**
	 * get {@link Pager#count} property
	 *
	 * @return get the count property
	 **/
	public int getCount()
	{
		return count;
	}
	
	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("start", start).append("count", count).toString();
	}
}
