package com.forestbt.vo;

import java.util.ArrayList;
import java.util.List;

import com.forestbt.interfaces.Ground;
import com.forestbt.interfaces.Tree;

public class GroundVO implements Ground
{

	private int humidity;
	private int fertility;
	private final List<Tree> treeList;

	public GroundVO()
	{
		this(0, 0);
	}

	public GroundVO(int humidity, int fertility)
	{
		this.humidity = humidity;
		this.fertility = fertility;
		treeList = new ArrayList<Tree>();
	}

	@Override
	public void setHumidity(int humidity)
	{
		this.humidity = humidity;
	}

	@Override
	public int getHumidity()
	{
		return humidity;
	}

	@Override
	public void setFertility(int fertility)
	{
		this.fertility = fertility;
	}

	@Override
	public int getFertility()
	{
		return fertility;
	}

	@Override
	public void removeTree(Tree tree)
	{
		treeList.remove(tree);
	}

	@Override
	public void removeAllTrees()
	{
		treeList.clear();
	}

	@Override
	public void addTrees(List<Tree> trees)
	{
		treeList.remove(trees);
	}

	@Override
	public void addTree(int index, Tree tree)
	{
		treeList.add(index, tree);
	}

}
