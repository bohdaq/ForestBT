package com.forestbt;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.forestbt.vo.GroundVO;
import com.forestbt.vo.OakLeafVO;
import com.forestbt.vo.OakVO;
import com.forestbt.xml.ForestHandler;

public class ForestBT
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GroundVO ground = new GroundVO();
		OakVO oak = new OakVO();
		OakLeafVO oakleaf = new OakLeafVO();
		oak.addLeaf(0, oakleaf);
		ground.addTree(0, oak);
		System.out.println("Parsing...");
		try
		{

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			ForestHandler handler = new ForestHandler();
			saxParser
					.parse("src/com/forestbt/assets/xml/oak_tree.xml", handler);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
