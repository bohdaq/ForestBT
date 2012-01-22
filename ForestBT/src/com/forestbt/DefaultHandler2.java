package com.forestbt;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

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

	public DefaultHandler2()
	{
		this("src/com/forestbt/assets/xml/oak_tree.xml");
	}

	public DefaultHandler2(String path)
	{
		try
		{

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler2 handler = new DefaultHandler2();
			saxParser.parse(path, handler);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
	}

	@Override
	public void endDocument() throws SAXException
	{
		System.out.println(bTree);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
	}

	@Override
	public void startDocument() throws SAXException
	{
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		if (qName.equalsIgnoreCase("TREE"))
		{
			bTree = true;
		}
		if (qName.equalsIgnoreCase("ID"))
		{
			bId = true;
		}
	}

}
