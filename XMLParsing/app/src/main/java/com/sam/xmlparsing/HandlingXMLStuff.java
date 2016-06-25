package com.sam.xmlparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Samir on 25.6.2016.
 */
public class HandlingXMLStuff extends DefaultHandler {

    XMLDataCollector info = new XMLDataCollector();

    public String getInformation(){
        return info.dataToString();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes);
    if(localName.equals("city")){
        String city = attributes.getValue("data");// we get the info and need to parse
        info.setCity(city);
    }else if(localName.equals("temp_f")) {
        String temp = attributes.getValue("data");
        info.setTemp(Integer.parseInt(temp));
    }
    }
}
