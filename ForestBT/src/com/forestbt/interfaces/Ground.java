package com.forestbt.interfaces;

import java.util.List;

public interface Ground
{
	void setHumidity(int humidity);

	int getHumidity();

	void setFertility(int fertility);

	int getFertility();

	void removeAllTrees();

	void addTrees(List<Tree> trees);

	void addTree(int index, Tree tree);

	void addTree(Tree tree);

	Tree getTree(long id);

	void removeTree(Tree id);
}
