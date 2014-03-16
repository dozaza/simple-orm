package com.datayes.pms.filehelper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    public static Boolean initialize(File file) {
        if ( file.exists() ) {
            return initRootElement(file);
        }

        return false;
    }

    public static Boolean initialize(String path, String name) {
        File file = new File(path + FileHelper.getSeparator() + name);
        return initialize(file);
    }

    public static Boolean initialize(String name) {
        String path = FileHelper.getCurrentPath();
        return initialize(path, name);
    }

    public static Element get

    public static Element getElement(String tagName) {

    }

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
