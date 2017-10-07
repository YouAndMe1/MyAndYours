

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
import java.util.List;

public class ParserBook extends Parser{
    List<Book> listOfBooks = new ArrayList<Book>();


    public static void main(String[] args) {

    }

    public void readFile(String path) {
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                listOfBooks.add(new Book(formatString(readLine)));
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
            Element rootElement = doc.createElement("books");
            doc.appendChild(rootElement);

            // user element

            for (Integer i = 0; i < listOfBooks.size(); i++) {
                Element elements = doc.createElement("book");
                rootElement.appendChild(elements);

                // setting attribute to element
                Attr attr = doc.createAttribute("id");
                attr.setValue(i.toString());
                elements.setAttributeNode(attr);

                //setting data to element
                Element element0 = doc.createElement("title");
                element0.appendChild(doc.createTextNode(listOfBooks.get(i).getTitle()));
                elements.appendChild(element0);

                Element element1 = doc.createElement("date");
                element1.appendChild(doc.createTextNode(listOfBooks.get(i).getDate()));
                elements.appendChild(element1);

                Element element2 = doc.createElement("author");
                element2.appendChild(doc.createTextNode(listOfBooks.get(i).getAuthor()));
                elements.appendChild(element2);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("test_book.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printInConsole() {
        for (Book p : listOfBooks) {
            System.out.println(p.toString());
        }

    }

}
