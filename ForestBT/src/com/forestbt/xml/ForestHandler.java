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

	// boolean vars are used for understanding what to parse

	private boolean isTree = false;
	private boolean isLeaf = false;

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
		if (isTree)
		{
			if (qName.equalsIgnoreCase(ForestElements.AGE))
			{
				tempOakVO.setAge(Integer.parseInt(tempValue.toString()));
				System.out.println("Age: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.HEIGHT))
			{
				tempOakVO.setHeight(Integer.parseInt(tempValue.toString()));
				System.out.println("Height: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.ID))
			{
				tempOakVO.setId(Long.parseLong(tempValue.toString()));
				System.out.println("ID: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.WIDTH))
			{
				tempOakVO.setWidth(Integer.parseInt(tempValue.toString()));
				System.out.println("Width: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.LEAFCOUNT))
			{
				leavesNumber = Integer.parseInt(tempValue.toString());
				System.out.println("Number of leaves: " + tempValue);
			}
		}

		if (isLeaf)
		{
			if (qName.equalsIgnoreCase(ForestElements.COLOR))
			{
				tempOakLeafVO.setColor(tempValue.toString());
				System.out.println("Color: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.HEIGHT))
			{
				tempOakLeafVO.setHeight(Integer.parseInt(tempValue.toString()));
				System.out.println("Height: " + tempValue);
			}
			if (qName.equalsIgnoreCase(ForestElements.WIDTH))
			{
				tempOakLeafVO.setWidth(Integer.parseInt(tempValue.toString()));
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

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		tempValue.delete(0, tempValue.length());

		// TREE processing
		if (qName.equalsIgnoreCase(ForestElements.TREE))
		{
			isLeaf = false;
			isTree = true;
			tempOakVO = new OakVO();
			System.out.println("\nTree created");
		}
		if (qName.equalsIgnoreCase(ForestElements.LEAF))
		{
			isTree = false;
			isLeaf = true;
			tempOakLeafVO = new OakLeafVO();
			System.out.println("LEAF  CREATED");
		}
	}

}
