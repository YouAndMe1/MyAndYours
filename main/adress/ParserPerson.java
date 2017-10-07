

import com.sun.deploy.util.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserPerson extends Parser{
    List<Person> listOfPersons = new ArrayList<Person>();


    public static void main(String[] args) {
    }

    public void readFile(String path) {
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                listOfPersons.add(new Person(formatString(readLine)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wrightFile() {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            // user element

            for (Integer i = 0; i < listOfPersons.size(); i++) {
                Element elements = doc.createElement("user");
                rootElement.appendChild(elements);

                // setting attribute to element
                Attr attr = doc.createAttribute("id");
                attr.setValue(i.toString());
                elements.setAttributeNode(attr);

                //setting data to element
                Element element0 = doc.createElement("fio");
                element0.appendChild(doc.createTextNode(listOfPersons.get(i).getFio()));
                elements.appendChild(element0);

                Element element1 = doc.createElement("age");
                element1.appendChild(doc.createTextNode(listOfPersons.get(i).getAge()));
                elements.appendChild(element1);

                Element element2 = doc.createElement("address");
                element2.appendChild(doc.createTextNode(listOfPersons.get(i).getAddress()));
                elements.appendChild(element2);

                Element element3 = doc.createElement("cellPhone");
                element3.appendChild(doc.createTextNode(listOfPersons.get(i).getCellPhone()));
                elements.appendChild(element3);

                Element element4 = doc.createElement("description");
                element4.appendChild(doc.createTextNode(listOfPersons.get(i).getDescription()));
                elements.appendChild(element4);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("test_person.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printInConsole() {
        for (Person p : listOfPersons) {
            System.out.println(p.toString());
        }

    }

}
