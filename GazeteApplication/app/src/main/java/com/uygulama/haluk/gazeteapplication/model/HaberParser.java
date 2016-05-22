package com.uygulama.haluk.gazeteapplication.model;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Samir on 30.04.2016.
 */
public class HaberParser {
    private String webAddress;

    public HaberParser(String webAdress) {
        this.webAddress = webAdress;
    }

    public List<Haber> haberleriCek() throws Exception {
        List<Haber> haberler = new ArrayList<Haber>();

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new NewsXmlHandler(haberler));
        /*
            icerik yuklemesi icin saxParser uzerinden xmlReader olusturuyoruz
            Bir XML dokumanini "parse" etmek icin bir Handler vermemiz gerekmektedir
            Bu handler, dokument ile ilgili tum olaylarda cagirilacaktir
            Biz startElement, characters ve endElement metotlarini dolduruyoruz.

         */


        // icerik yuklemesinden sonra karakter kontrolu yapiyoruz
        xmlReader.parse(new InputSource(new StringReader(downloadXmlPage())));

        return haberler;
    }


    public String downloadXmlPage() throws Exception {
        final String singleQuote = "&amp;#39;";
        final String doubleQuote = "&amp;#34";

        URL url = new URL(webAddress);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString().replace(singleQuote, "'").replace(doubleQuote, "\"");
    }


    private class NewsXmlHandler extends DefaultHandler {

        private final List<Haber> haberler;

        private final String ITEM = "item";
        private final String TITLE = "title";
        private final String DESCRIPTION = "description";
        private final String LINK = "link";
        private final String GUID = "guid";
        private final String ENCLOSURE = "enclosure";
        private final String URL = "enclosure url";

        private boolean isFirstItem;
        private boolean isTitle;
        private boolean isDescription;
        private boolean isLink;
        private boolean isGuid;
        private boolean isEnclosure;

        private Haber suAnkiHaber;

        public NewsXmlHandler(List<Haber> haberler) {
            this.haberler = haberler;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(ITEM)) {
                isFirstItem = true;
                suAnkiHaber = new Haber();
            } else if (qName.equals(TITLE)) {
                isTitle = true & isFirstItem;
            } else if (qName.equals(DESCRIPTION)) {
                isDescription = true & isFirstItem;
            } else if (qName.equals(LINK)) {
                isLink = true & isFirstItem;
            } else if (qName.equals(GUID)) {
                isGuid = true & isFirstItem;
            } else if (qName.equals(URL)) {
                suAnkiHaber.setResimUrl(attributes.getValue(URL));
            }
        }


        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isTitle) {
                suAnkiHaber.setEtiket(new String(ch, start, length));
                isTitle = false;
            } else if (isDescription) {
                suAnkiHaber.setAciklama(new String(ch, start, length));
                isDescription = false;
            } else if (isLink) {
                suAnkiHaber.setBaglanti(new String(ch, start, length));
                isLink = false;
            } else if (isGuid) {
                suAnkiHaber.setKaynak(new String(ch, start, length));
                isGuid = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(ITEM)) {
                haberler.add(suAnkiHaber);
            }
        }
    }
}






