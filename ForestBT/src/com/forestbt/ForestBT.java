package com.forestbt;

import com.forestbt.vo.GroundVO;
import com.forestbt.vo.OakLeafVO;
import com.forestbt.vo.OakVO;

public class ForestBT
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GroundVO ground = new GroundVO();
		OakVO oak = new OakVO();
		OakLeafVO oakleaf = new OakLeafVO(0, "00ff00", 10, 5);
		oak.addLeaf(0, oakleaf);
		ground.addTree(0, oak);
		System.out.println("All done");
	}

}
