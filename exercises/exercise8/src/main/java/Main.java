import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Sample XML
        String xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><BookShelf>" +
                "<Book><title>Java Programming</title><publishedYear>2021</publishedYear><numberOfPages>500</numberOfPages><authors>" +
                "<author>David Dai</author><author>Ziqi Meng</author></authors></Book>" +
                "<Book><title>Data Structures</title><publishedYear>2022</publishedYear><numberOfPages>400</numberOfPages><authors>" +
                "<author>ABCD</author></authors></Book>" +
                "<Book><title>Machine Learning</title><publishedYear>2023</publishedYear><numberOfPages>600</numberOfPages><authors>" +
                "<author>ABCD</author><author>EFG</author></authors></Book></BookShelf>";

        // Sample JSON
        String jsonInput = "{ \"BookShelf\": { \"Book\": [ " +
                "{ \"title\": \"Java Programming\", \"publishedYear\": 2020, \"numberOfPages\": 300, \"authors\": [ \"David Dai\", \"Ziqi Meng\" ] }, " +
                "{ \"title\": \"Web Development\", \"publishedYear\": 2021, \"numberOfPages\": 400, \"authors\": [ \"Lady Gaga\" ] }, " +
                "{ \"title\": \"Databases\", \"publishedYear\": 2019, \"numberOfPages\": 500, \"authors\": [ \"John Smith\", \"Taylor Swift\" ] } ] } }";

        // Parse and print XML
        parseXML(xmlInput);

        // Parse and print JSON
        parseJSON(jsonInput);

        // Add an entry to XML programmatically
        xmlInput = addBookToXML(xmlInput, "New Book", "2024", "700", "New Author");

        // Parse and print modified XML
        parseXML(xmlInput);

        // Add an entry to JSON programmatically
        jsonInput = addBookToJSON(jsonInput, "Another Book", "2025", "800", new String[]{"Author A", "Author B"});

        // Parse and print modified JSON
        parseJSON(jsonInput);
    }

    private static void parseXML(String xmlInput) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new org.xml.sax.InputSource(new java.io.StringReader(xmlInput)));

            NodeList bookList = document.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                    System.out.println("Number of Pages: " + bookElement.getElementsByTagName("numberOfPages").item(0).getTextContent());

                    NodeList authorsList = bookElement.getElementsByTagName("authors");
                    for (int j = 0; j < authorsList.getLength(); j++) {
                        Node authorsNode = authorsList.item(j);
                        if (authorsNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element authorsElement = (Element) authorsNode;
                            NodeList authorList = authorsElement.getElementsByTagName("author");
                            System.out.print("Authors: ");
                            for (int k = 0; k < authorList.getLength(); k++) {
                                System.out.print(authorList.item(k).getTextContent());
                                if (k < authorList.getLength() - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseJSON(String jsonInput) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonInput);

            JsonNode bookArray = rootNode.path("BookShelf").path("Book");
            for (JsonNode bookNode : bookArray) {
                System.out.println("Title: " + bookNode.path("title").asText());
                System.out.println("Published Year: " + bookNode.path("publishedYear").asText());
                System.out.println("Number of Pages: " + bookNode.path("numberOfPages").asText());

                JsonNode authorsArray = bookNode.path("authors");
                System.out.print("Authors: ");
                for (JsonNode authorNode : authorsArray) {
                    System.out.print(authorNode.asText());
                    if (authorNode != authorsArray.get(authorsArray.size() - 1)) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String addBookToXML(String xmlInput, String title, String publishedYear, String numberOfPages, String author) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new org.xml.sax.InputSource(new java.io.StringReader(xmlInput)));

            Element bookShelf = (Element) document.getElementsByTagName("BookShelf").item(0);

            Element newBook = document.createElement("Book");

            Element titleElement = document.createElement("title");
            titleElement.appendChild(document.createTextNode(title));
            newBook.appendChild(titleElement);

            Element publishedYearElement = document.createElement("publishedYear");
            publishedYearElement.appendChild(document.createTextNode(publishedYear));
            newBook.appendChild(publishedYearElement);

            Element numberOfPagesElement = document.createElement("numberOfPages");
            numberOfPagesElement.appendChild(document.createTextNode(numberOfPages));
            newBook.appendChild(numberOfPagesElement);

            Element authorsElement = document.createElement("authors");
            Element authorElement = document.createElement("author");
            authorElement.appendChild(document.createTextNode(author));
            authorsElement.appendChild(authorElement);
            newBook.appendChild(authorsElement);

            bookShelf.appendChild(newBook);

            return convertDocumentToString(document);
        } catch (Exception e) {
            e.printStackTrace();
            return xmlInput;
        }
    }

    private static String addBookToJSON(String jsonInput, String title, String publishedYear, String numberOfPages, String[] authors) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonInput);

            // Create a new book node
            JsonNode newBookNode = objectMapper.createObjectNode()
                    .put("title", title)
                    .put("publishedYear", publishedYear)
                    .put("numberOfPages", numberOfPages)
                    .putArray("authors")
                    .add(authors[0])
                    .add(authors[1]);

            // Add the new book node to the existing JSON structure
            ((com.fasterxml.jackson.databind.node.ArrayNode) rootNode.path("BookShelf").path("Book")).add(newBookNode);

            // Convert the updated JSON to a string
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
            return jsonInput;
        }
    }

    private static String convertDocumentToString(Document document) {
        try {
            java.io.StringWriter sw = new java.io.StringWriter();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(sw));
            return sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}