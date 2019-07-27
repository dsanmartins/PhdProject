package br.ufscar.sas.modisco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class AddNamespaces {

	
	public void parser(String path) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new File(path));
		Element documentElement = document.getDocumentElement();
		// Add name space to root element as attribute
		documentElement.setAttribute("xmlns:structure", "http://www.eclipse.org/MoDisco/kdm/structure");
		String xml = transformXmlNodeToXmlString(documentElement);
		FileWriter fw = new FileWriter(path,false);
		fw.write(xml);
		fw.close();
	}
	
	private static String transformXmlNodeToXmlString(Node node)
	        throws TransformerException {
	    TransformerFactory transFactory = TransformerFactory.newInstance();
	    Transformer transformer = transFactory.newTransformer();
	    StringWriter buffer = new StringWriter();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    transformer.transform(new DOMSource(node), new StreamResult(buffer));
	    String xml = buffer.toString();
	    return xml;
	}
}
