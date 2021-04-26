package service.filesService;

import model.Song;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;


public class PrinterXML {
    public static void printToXML(ArrayList<Song> songList, String stringPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("songs");
            document.appendChild(rootElement);
            System.out.println();

            for (Song song : songList) {

                Element esong = document.createElement("song");

                rootElement.appendChild(esong);

                Element etitle = document.createElement("title");
                etitle.appendChild(document.createTextNode(song.getTitle()));
                esong.appendChild(etitle);

                Element eauthor = document.createElement("author");
                eauthor.appendChild(document.createTextNode(song.getAuthor()));
                esong.appendChild(eauthor);

                Element ealbum = document.createElement("album");
                ealbum.appendChild(document.createTextNode(song.getAlbum()));
                esong.appendChild(ealbum);

                Element ecategory = document.createElement("category");
                ecategory.appendChild(document.createTextNode(String.valueOf(song.getCategory())));
                esong.appendChild(ecategory);

                Element evotes = document.createElement("votes");
                evotes.appendChild(document.createTextNode(String.valueOf(song.getVotes())));
                esong.appendChild(evotes);

            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(stringPath));
            transformer.transform(domSource, streamResult);

            System.out.println("Zapisano plik pomyślnie.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
