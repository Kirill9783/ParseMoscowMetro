package myOptions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseWebPage {

    public String parseWebPage(String url) {
        StringBuilder builder = new StringBuilder();
        try {
            Document doc = Jsoup.connect(url).get();
            doc.forEach(line -> builder.append(line).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
