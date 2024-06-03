package app.view;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javafx.stage.Stage;
import resource.utils.Constants;

import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;

public class Carte {
    private Map<String, String> departements;

    public Carte(Stage primaryStage) {
        departements = new HashMap<>();
        loadDepartementsFromSVG(Constants.CARTE_PATH);
    }

    private void loadDepartementsFromSVG(String svgFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(svgFilePath);

            NodeList paths = document.getElementsByTagName("path");
            for (int i = 0; i < paths.getLength(); i++) {
                Element path = (Element) paths.item(i);
                String id = path.getAttribute("id");
                String d = path.getAttribute("d");
                if (id != null && d != null) {
                    departements.put(id, d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDepartementPath(String id) {
        return departements.get(id);
    }

}
