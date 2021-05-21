package kr.or.ddit.xmlParsing;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("application-context.xml");

		// root 구하기
		Element root = document.getDocumentElement();

		// root의 속성
		// System.out.println("class name: " + root.getAttribute("name"));

		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get
		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) { // 해당 노드의 종류 판정(Element일 때)
				Element ele = (Element) node;

				
				
				
				String nodeName = ele.getNodeName();
				System.out.println("node name: " + nodeName);
				System.out.println("key: " + ele.getAttribute("id"));
				System.out.println("value: " + ele.getAttribute("class"));
				NodeList childeren2 = ele.getChildNodes();
				for (int a = 0; a < childeren2.getLength(); a++) {
					Node node2 = childeren2.item(a);
					if (node2.getNodeType() == Node.ELEMENT_NODE) {
						Element ele2 = (Element) node2;
						String nodeName2 = ele2.getNodeName();
						System.out.println("node name2: " + nodeName2);
						System.out.println("name: " + ele2.getAttribute("name"));
						System.out.println("ref-value: " + ele2.getAttribute("ref-value"));
					}
				}
			}
		}
	}
}