package service.filesService;

import model.MusicCategory;
import model.Song;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

public class ReaderXML {

    public static ArrayList<Song> readSongsFromXML(String stringPath) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Song> songs = new ArrayList<>();
        Song song;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(stringPath));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("song");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                song = new Song();
                try {
                    song.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                    song.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
                    song.setAlbum(element.getElementsByTagName("album").item(0).getTextContent());
                    song.setCategory(MusicCategory.valueOf(element.getElementsByTagName("category").item(0).getTextContent().toUpperCase()));
                    song.setVotes(Integer.parseInt(element.getElementsByTagName("votes").item(0).getTextContent()));
                } catch (IllegalArgumentException exception) {
                    System.out.println("Zły format piosenki " + song.getTitle());
                }
                songs.add(song);
            }
        }
        return songs;
    }
}
