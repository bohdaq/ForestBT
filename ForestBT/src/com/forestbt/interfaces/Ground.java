package com.forestbt.interfaces;

import java.util.List;

public interface Ground
{
	void setHumidity(int humidity);

	int getHumidity();

	void setFertility(int fertility);

	int getFertility();

	void removeTree(Tree tree);

	void removeAllTrees();

	void addTrees(List<Tree> trees);

	void addTree(int index, Tree tree);
}
