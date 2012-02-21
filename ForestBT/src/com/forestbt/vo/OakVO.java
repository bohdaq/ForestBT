package com.forestbt.vo;

import java.util.ArrayList;
import java.util.List;

import com.forestbt.interfaces.Leaf;
import com.forestbt.interfaces.Tree;

public class OakVO implements Tree
{

	private long id;
	private int height;
	private int width;
	private int age;
	private final List<Leaf> leafList;

	public OakVO()
	{
		this(0l, 0, 0, 0);
	}

	public OakVO(long id, int height, int width, int age)
	{
		this.id = id;
		this.height = height;
		this.width = width;
		this.age = age;
		leafList = new ArrayList<Leaf>();
	}

	@Override
	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public int getAge()
	{
		return age;
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

	@Override
	public void addLeaf(int index, Leaf leaf)
	{
		leafList.add(index, leaf);
	}

	@Override
	public void removeAllLeaves()
	{
		leafList.clear();
	}

	@Override
	public void addLeaves(List<Leaf> leaves)
	{
		leafList.addAll(leaves);
	}

	@Override
	public void removeLeaf(Leaf leaf)
	{
		leafList.remove(leaf);
	}

	@Override
	public void addLeaf(Leaf leaf)
	{
		leafList.add(leaf);
	}

	@Override
	public Leaf getLeaf(long id)
	{
		return leafList.get((int) id);
	}

}
