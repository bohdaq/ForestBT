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

	private boolean bTree = false;
	private boolean bId = false;
	private boolean bHeight = false;
	private boolean bWidth = false;
	private boolean bAge = false;

	private boolean bLeafDetails = false;
	private boolean bLeafCount = false;

	private boolean bLeaf = false;
	private boolean bColor = false;
	private boolean bHeightLeaf = false;
	private boolean bWidthLeaf = false;

	// temp VO

	private OakLeafVO tempOakLeafVO;
	private OakVO tempOakVO;
	private String tempValue;
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
		tempValue = new String(ch, start, length);

		if (bId)
		{
			tempOakVO.setId(Long.parseLong(tempValue));
			System.out.println("ID : " + tempValue);

		}
		if (bHeight)
		{
			tempOakVO.setHeight(Integer.parseInt(tempValue));
			System.out.println("Height : " + tempValue);

		}
		if (bWidth) // old: bWidth && bLeafDetails == false
		{
			tempOakVO.setWidth(Integer.parseInt(tempValue));
			System.out.println("Width : " + tempValue);

		}
		if (bAge)
		{
			tempOakVO.setAge(Integer.parseInt(tempValue));
			System.out.println("Age : " + tempValue);

		}
		// past here
		if (bColor)
		{
			tempOakLeafVO.setColor(tempValue);
			System.out.println("Color : " + tempValue);

		}
		if (bHeightLeaf)
		{
			tempOakLeafVO.setHeight(Integer.parseInt(tempValue));
			System.out.println("LeafHeight : " + tempValue);

		}
		if (bWidthLeaf)
		{
			tempOakLeafVO.setWidth(Integer.parseInt(tempValue));
			System.out.println("LeafWidth : " + tempValue);

		}
		if (bLeafCount)
		{
			leavesNumber = Integer.parseInt(tempValue);
			System.out.println("NumberofLeaves : " + tempValue);
		}

		// erasing it after use
		tempValue = null;
	}

	@Override
	public void endDocument() throws SAXException
	{
		System.out.println("\nEnd Document.");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		// TREE processing
		if (qName.equalsIgnoreCase(ForestElements.tree))
		{
			forest.addTree(sum, tempOakVO);
			sum++;
			bTree = false;
			tempOakVO = null;
			System.out.println("Tree added to forest\nTree deleted.");
		}
		if (qName.equalsIgnoreCase(ForestElements.id))
		{
			bId = false;
			// System.out.println("ID FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.height)
				&& bLeafDetails == false)
		{
			bHeight = false;
			// System.out.println("HEIGHT FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.width)
				&& bLeafDetails == false)
		{
			bWidth = false;
			// System.out.println("WIDTH FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.age))
		{
			bAge = false;
			// System.out.println("AGE FALSE");
		}

		// LEAF processing
		if (qName.equalsIgnoreCase(ForestElements.leafDetails))
		{
			bLeafDetails = false;
			// System.out.println("LEAFDETAILS FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.leafCount))
		{
			bLeafCount = false;
			// System.out.println("LEAFCOUNT FALSE ");
		}
		if (qName.equalsIgnoreCase(ForestElements.leaf))
		{
			for (int i = 0; i < leavesNumber; i++)
			{
				tempOakVO.addLeaf(i, tempOakLeafVO);
			}
			System.out.println("Succesfully added " + leavesNumber + " leaves");
			bLeaf = false;
			tempOakLeafVO = null;
			System.out.println("LEAF  DELETED");
		}
		if (qName.equalsIgnoreCase(ForestElements.color))
		{
			bColor = false;
			// System.out.println("COLOR  FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.heightLeaf)
				&& bLeafDetails == true)
		{
			bHeightLeaf = false;
			// System.out.println("HEIGHTLEAF  FALSE");
		}
		if (qName.equalsIgnoreCase(ForestElements.widthLeaf)
				&& bLeafDetails == true)
		{
			bWidthLeaf = false;
			// System.out.println("WIDTHLEAF  FALSE");
		}
	}

	@Override
	public void startDocument() throws SAXException
	{
		System.out.println("Document started");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		// TREE processing
		if (qName.equalsIgnoreCase(ForestElements.tree))
		{
			bTree = true;
			tempOakVO = new OakVO();
			System.out.println("\nTree created");
		}
		if (qName.equalsIgnoreCase(ForestElements.id))
		{
			bId = true;
			// System.out.println("ID TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.height)
				&& bLeafDetails == false)
		{
			bHeight = true;
			// System.out.println("HEIGHT TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.width)
				&& bLeafDetails == false)
		{
			bWidth = true;
			// System.out.println("WIDTH TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.age))
		{
			bAge = true;
			// System.out.println("AGE TRUE");
		}

		// LEAF processing
		if (qName.equalsIgnoreCase(ForestElements.leafDetails))
		{
			bLeafDetails = true;
			// System.out.println("LEAFDETAILS TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.leafCount))
		{
			bLeafCount = true;
			// System.out.println("LEAFCOUNT TRUE ");
		}
		if (qName.equalsIgnoreCase(ForestElements.leaf))
		{
			bLeaf = true;
			tempOakLeafVO = new OakLeafVO();
			System.out.println("LEAF  CREATED");
		}
		if (qName.equalsIgnoreCase(ForestElements.color))
		{
			bColor = true;
			// System.out.println("COLOR  TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.heightLeaf)
				&& bLeafDetails == true)
		{
			bHeightLeaf = true;
			// System.out.println("HEIGHTLEAF  TRUE");
		}
		if (qName.equalsIgnoreCase(ForestElements.widthLeaf)
				&& bLeafDetails == true)
		{
			bWidthLeaf = true;
			// System.out.println("WIDTHLEAF  TRUE");
		}
	}

}
