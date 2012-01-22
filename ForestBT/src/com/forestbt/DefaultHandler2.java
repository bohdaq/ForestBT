package com.forestbt;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.forestbt.vo.GroundVO;
import com.forestbt.vo.OakLeafVO;
import com.forestbt.vo.OakVO;

public class DefaultHandler2 extends DefaultHandler
{
	// boolean vars are used for understanding what to parse

	boolean bTree = false;
	boolean bId = false;
	boolean bHeight = false;
	boolean bWidth = false;
	boolean bAge = false;

	boolean bLeafDetails = false;
	boolean bLeafCount = false;

	boolean bLeaf = false;
	boolean bColor = false;
	boolean bHeightLeaf = false;
	boolean bWidthLeaf = false;

	// temp VO

	OakLeafVO tempOakLeafVO;
	OakVO tempOakVO;
	String tempValue;
	int leavesNumber;

	// resulting FOREST

	GroundVO forest = new GroundVO();

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
		if (bLeafCount)
		{
			leavesNumber = Integer.parseInt(tempValue);
			System.out.println("LeavesNumber : " + tempValue);

		}
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

		// erasing it after use
		tempValue = null;
	}

	@Override
	public void endDocument() throws SAXException
	{
		System.out.println("Document ended");
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		// TREE processing
		if (qName.equalsIgnoreCase("TREE"))
		{
			bTree = false;
			tempOakVO = null;
			System.out.println("\nTree nulled");
		}
		if (qName.equalsIgnoreCase("ID"))
		{
			bId = false;
			System.out.println("ID FALSE");
		}
		if (qName.equalsIgnoreCase("HEIGHT") && bLeafDetails == false)
		{
			bHeight = false;
			System.out.println("HEIGHT FALSE");
		}
		if (qName.equalsIgnoreCase("WIDTH") && bLeafDetails == false)
		{
			bWidth = false;
			System.out.println("WIDTH FALSE");
		}
		if (qName.equalsIgnoreCase("AGE"))
		{
			bAge = false;
			System.out.println("AGE FALSE");
		}

		// LEAF processing
		if (qName.equalsIgnoreCase("LEAFDETAILS"))
		{
			bLeafDetails = false;
			System.out.println("LEAFDETAILS FALSE");
		}
		if (qName.equalsIgnoreCase("LEAFCOUNT"))
		{
			bLeafCount = false;
			System.out.println("LEAFCOUNT FALSE ");
		}
		if (qName.equalsIgnoreCase("LEAF"))
		{
			bLeaf = false;
			tempOakLeafVO = null;
			System.out.println("LEAF  DELETED");
		}
		if (qName.equalsIgnoreCase("COLOR"))
		{
			bColor = false;
			System.out.println("COLOR  FALSE");
		}
		if (qName.equalsIgnoreCase("HEIGHT") && bLeafDetails == true)
		{
			bHeightLeaf = false;
			System.out.println("HEIGHTLEAF  FALSE");
		}
		if (qName.equalsIgnoreCase("WIDTH") && bLeafDetails == true)
		{
			bWidthLeaf = false;
			System.out.println("WIDTHLEAF  FALSE");
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
		if (qName.equalsIgnoreCase("TREE"))
		{
			bTree = true;
			tempOakVO = new OakVO();
			System.out.println("\nTree created");
		}
		if (qName.equalsIgnoreCase("ID"))
		{
			bId = true;
			System.out.println("ID TRUE");
		}
		if (qName.equalsIgnoreCase("HEIGHT") && bLeafDetails == false)
		{
			bHeight = true;
			System.out.println("HEIGHT TRUE");
		}
		if (qName.equalsIgnoreCase("WIDTH") && bLeafDetails == false)
		{
			bWidth = true;
			System.out.println("WIDTH TRUE");
		}
		if (qName.equalsIgnoreCase("AGE"))
		{
			bAge = true;
			System.out.println("AGE TRUE");
		}

		// LEAF processing
		if (qName.equalsIgnoreCase("LEAFDETAILS"))
		{
			bLeafDetails = true;
			System.out.println("LEAFDETAILS TRUE");
		}
		if (qName.equalsIgnoreCase("LEAFCOUNT"))
		{
			bLeafCount = true;
			System.out.println("LEAFCOUNT TRUE ");
		}
		if (qName.equalsIgnoreCase("LEAF"))
		{
			bLeaf = true;
			tempOakLeafVO = new OakLeafVO();
			System.out.println("LEAF  CREATED");
		}
		if (qName.equalsIgnoreCase("COLOR"))
		{
			bColor = true;
			System.out.println("COLOR  TRUE");
		}
		if (qName.equalsIgnoreCase("HEIGHT") && bLeafDetails == true)
		{
			bHeightLeaf = true;
			System.out.println("HEIGHTLEAF  TRUE");
		}
		if (qName.equalsIgnoreCase("WIDTH") && bLeafDetails == true)
		{
			bWidthLeaf = true;
			System.out.println("WIDTHLEAF  TRUE");
		}
	}

}
