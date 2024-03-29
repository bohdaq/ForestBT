package com.forestbt.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.forestbt.interfaces.Ground;
import com.forestbt.vo.GroundVO;
import com.forestbt.vo.OakLeafVO;
import com.forestbt.vo.OakVO;

public class ForestHandler extends DefaultHandler
{

	private int CURRENT_LEVEL = -1;
	private final int LEVEL_TREE = 1;
	private final int LEVEL_LEAF = 2;

	// temp VO

	private OakLeafVO tempOakLeafVO;
	private OakVO tempOakVO;
	private final StringBuilder tempValue = new StringBuilder();
	private int leavesNumber;
	private int sum;

	// resulting FOREST

	private final GroundVO forest = new GroundVO();

	public Ground getResult()
	{
		return forest;
	}

	// Overriding default handler methods

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{

		// storing characters in tempValue
		tempValue.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		if (CURRENT_LEVEL == LEVEL_TREE)
		{
			parseTree(qName);
		}

		if (CURRENT_LEVEL == LEVEL_LEAF)
		{
			parseLeaf(qName);
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		tempValue.delete(0, tempValue.length());

		if (qName.equalsIgnoreCase(ForestElements.TREE))
		{
			CURRENT_LEVEL = LEVEL_TREE;
			tempOakVO = new OakVO();
			System.out.println("\nTree created");
		}
		if (qName.equalsIgnoreCase(ForestElements.LEAF))
		{
			CURRENT_LEVEL = LEVEL_LEAF;
			tempOakLeafVO = new OakLeafVO();
			System.out.println("LEAF  CREATED");
		}

	}

	private void parseTree(String qName)
	{

		if (qName.equalsIgnoreCase(ForestElements.AGE))
		{
			tempOakVO.setAge(Integer.parseInt(tempValue.toString().trim()));
			System.out.println("Age: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.HEIGHT))
		{
			tempOakVO.setHeight(Integer.parseInt(tempValue.toString().trim()));
			System.out.println("Height: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.ID))
		{
			tempOakVO.setId(Long.parseLong(tempValue.toString().trim()));
			System.out.println("ID: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.WIDTH))
		{
			tempOakVO.setWidth(Integer.parseInt(tempValue.toString().trim()));
			System.out.println("Width: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.LEAFCOUNT))
		{
			leavesNumber = Integer.parseInt(tempValue.toString().trim());
			System.out.println("Number of leaves: " + tempValue);
		}
	}

	private void parseLeaf(String qName)
	{
		if (qName.equalsIgnoreCase(ForestElements.COLOR))
		{
			tempOakLeafVO.setColor(tempValue.toString().trim());
			System.out.println("Color: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.HEIGHT))
		{
			tempOakLeafVO.setHeight(Integer.parseInt(tempValue.toString()
					.trim()));
			System.out.println("Height: " + tempValue);
		}
		if (qName.equalsIgnoreCase(ForestElements.WIDTH))
		{
			tempOakLeafVO.setWidth(Integer
					.parseInt(tempValue.toString().trim()));
			System.out.println("Width: " + tempValue);

			// adding leaf to tree numberLeaf times
			for (int i = 0; i < leavesNumber; i++)
				tempOakVO.addLeaf(i, tempOakLeafVO);

			// adding tree to the forest
			forest.addTree(sum, tempOakVO);
			sum++;
		}
	}

}
