package com.feliperibeiro_correio.app.utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class BuilderParse {

    public static Document builder(String retorno) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(retorno));
        return builder.parse(src);
    }

}
