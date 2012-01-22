package com.forestbt.vo;

import com.forestbt.interfaces.Leaf;

public class OakLeafVO implements Leaf
{
	private long id;
	private String color;
	private int height;
	private int width;

	public OakLeafVO()
	{
		this(0, "0", 0, 0);
	}

	public OakLeafVO(long id, String color, int height, int width)
	{
		this.id = id;
		this.color = color;
		this.height = height;
		this.width = width;
	}

	@Override
	public void setColor(String color)
	{
		this.color = color;

	}

	@Override
	public String getColor()
	{
		return color;
	}

	@Override
	public void setId(long id)
	{
		this.id = id;
	}

	@Override
	public long getId()
	{
		return id;
	}

	@Override
	public void setHeight(int height)
	{
		this.height = height;
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public void setWidth(int width)
	{
		this.width = width;
	}

	@Override
	public int getWidth()
	{
		return width;
	}

}
