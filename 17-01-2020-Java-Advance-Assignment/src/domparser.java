import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
public class domparser {
   public static void main(String args[])throws ParserConfigurationException, SAXException, IOException {
	   DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
	   DocumentBuilder builder = factory.newDocumentBuilder();
	   
	   Document doc = builder.parse(new File("foodmenu.xml"));
	   
	   doc.getDocumentElement().normalize();
	   
	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("food");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Food name: " 
                  + eElement.getElementsByTagName("name").item(0).getTextContent());
               System.out.println("price : " 
                  + eElement
                  .getElementsByTagName("price")
                  .item(0)
                  .getTextContent());
               Node childnode = doc.getElementsByTagName("description").item(i).getFirstChild();
               System.out.println("description :"+doc.getElementsByTagName("description").item(0).getChildNodes().item(0).getTextContent());
//               for (int j=0;j<childnode.getLength();j++) {
//            	   System.out.println(childnode.item(j));    	   
//               }
               System.out.println("calories : " 
                  + eElement
                  .getElementsByTagName("calories")
                  .item(0)
                  .getTextContent());
            }
         }
      } 
   }

