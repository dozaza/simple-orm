package com.datayes.pms.filehelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * System: Ubuntu
 * User: baoan @datayes
 * Date: 14-3-14
 * Time: 下午3:33
 */
public class ConfigReader {

    private static Element rootElement = null;

    /*
        *
        * Initialize ConfigReader with a file
        *
     */
    public static Boolean initialize(File file) {
        if ( file.exists() ) {
            return initRootElement(file);
        }

        return false;
    }

    /*
        *
        * Initialize ConfigReader with a file path and name
        *
     */
    public static Boolean initialize(String path, String name) {
        File file = new File(path + FileHelper.getSeparator() + name);
        return initialize(file);
    }

    /*
        *
        * Initialize ConfigReader with the project current path and a file name
        *
     */
    public static Boolean initialize(String name) {
        String path = FileHelper.getCurrentPath();
        return initialize(path, name);
    }

    /*
        *
        * Get element of a super element with a tag name
        *
     */
    public static Element getElement(Element element, String tagName) {
        if ( null == element || tagName == null ) {
            return null;
        }
        NodeList list = element.getElementsByTagName(tagName);
        if ( null == list || list.getLength() <= 0 ) {
            return null;
        }
        return (Element)list.item(0);
    }

    /*
        *
        * Get element of root element with a tag name
        *
     */
    public static Element getElement(String tagName) {
        return getElement(rootElement, tagName);

    }

    /*
        *
        * Get root element
        *
     */
    public static Element getRootElement() {
        return rootElement;
    }


    /*
        *
        * private methods
        *
     */

    /*
        *
        * initialize root element with config file
        *
     */
    private static Boolean initRootElement(File file) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            rootElement = document.getDocumentElement();
            return true;
        }
        catch(Exception e) {
            // TODO: add log
            return false;
        }
    }
}
