import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * This is superclass for creating connection with any html page for future parsing
 */
public class Page {
    // making instance of document from jsoup
    private Document document;

    protected Document getDocument() {
        return document;
    }

    //this method will take url as an input parameter and make connection
    protected void connect( String url ) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
