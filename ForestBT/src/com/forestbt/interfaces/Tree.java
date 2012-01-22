package com.forestbt.interfaces;

import java.util.List;

public interface Tree
{
	void setAge(int age);

	int getAge();

	void setId(long id);

	long getId();

	void setHeight(int height);

	int getHeight();

	void setWidth(int width);

	int getWidth();

	void addLeaf(int index, Leaf leaf);

	void removeAllLeaves();

	void addLeaves(List<Leaf> leaves);

	void removeLeaf(Leaf leaf);
}
