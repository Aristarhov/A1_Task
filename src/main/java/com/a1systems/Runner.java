package com.a1systems;

import com.a1systems.utils.Config;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class Runner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
            Config.readConfig(args);
            final TestNG testNG = new TestNG(true);
            final Parser parser = new Parser("src/main/resources/test/googletest.xml");
            final List<XmlSuite> suites = parser.parseToList();
            testNG.setXmlSuites(suites);
            testNG.run();
    }
}
