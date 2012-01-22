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

	// resulting FOREST

	GroundVO forest = new GroundVO();

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
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
	}

}
