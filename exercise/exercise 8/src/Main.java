import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.Scanner;

public class Main {

    private static final String XML_DATA = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<BookShelf>\n" +
            "    <Book>\n" +
            "        <title>Java Programming</title>\n" +
            "        <publishedYear>2020</publishedYear>\n" +
            "        <numberOfPages>400</numberOfPages>\n" +
            "        <authors>\n" +
            "            <author>John Doe</author>\n" +
            "        </authors>\n" +
            "    </Book>\n" +
            "    <Book>\n" +
            "        <title>Data Structures and Algorithms</title>\n" +
            "        <publishedYear>2019</publishedYear>\n" +
            "        <numberOfPages>350</numberOfPages>\n" +
            "        <authors>\n" +
            "            <author>Jane Smith</author>\n" +
            "        </authors>\n" +
            "    </Book>\n" +
            "    <Book>\n" +
            "        <title>Python for Beginners</title>\n" +
            "        <publishedYear>2021</publishedYear>\n" +
            "        <numberOfPages>300</numberOfPages>\n" +
            "        <authors>\n" +
            "            <author>Michael Johnson</author>\n" +
            "        </authors>\n" +
            "    </Book>\n" +
            "</BookShelf>";

    private static final String JSON_DATA = "{\n" +
            "  \"BookShelf\": {\n" +
            "    \"Book\": [\n" +
            "      {\n" +
            "        \"title\": \"Java Programming\",\n" +
            "        \"publishedYear\": 2020,\n" +
            "        \"numberOfPages\": 400,\n" +
            "        \"authors\": [\n" +
            "          \"John Doe\"\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"title\": \"Data Structures and Algorithms\",\n" +
            "        \"publishedYear\": 2019,\n" +
            "        \"numberOfPages\": 350,\n" +
            "        \"authors\": [\n" +
            "          \"Jane Smith\"\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"title\": \"Python for Beginners\",\n" +
            "        \"publishedYear\": 2021,\n" +
            "        \"numberOfPages\": 300,\n" +
            "        \"authors\": [\n" +
            "          \"Michael Johnson\"\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) {
        System.out.println("Parsing XML...");
        parseXML(XML_DATA);

        System.out.println("\nParsing JSON...");
        parseJSON(JSON_DATA);

        // Adding a new book programmatically to JSON
        JSONObject jsonObject = new JSONObject(JSON_DATA);
        JSONObject newBook = new JSONObject();
        newBook.put("title", "Artificial Intelligence");
        newBook.put("publishedYear", 2022);
        newBook.put("numberOfPages", 450);
        JSONArray authorsArray = new JSONArray();
        authorsArray.put("Alan Turing");
        authorsArray.put("Grace Hopper");
        newBook.put("authors", authorsArray);

        JSONObject bookShelf = jsonObject.getJSONObject("BookShelf");
        JSONArray bookArray = bookShelf.getJSONArray("Book");
        bookArray.put(newBook);

        System.out.println("\nAfter adding a new book:");
        System.out.println(jsonObject.toString());

        // Re-parsing JSON after adding the new book
        System.out.println("\nRe-parsing JSON after adding a new book:");
        parseJSON(jsonObject.toString());
    }

    private static void parseXML(String xmlData) {
        try {
            JSONObject jsonObject = XML.toJSONObject(xmlData);
            System.out.println(jsonObject.toString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void parseJSON(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            System.out.println(jsonObject.toString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}