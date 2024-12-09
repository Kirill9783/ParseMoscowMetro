import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class LineNameAndNumber {

    private Document document;

    public LineNameAndNumber(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
        ;
    }

    public String parseLine() {
        StringBuilder builder = new StringBuilder();
        try {
            Elements lines = document.select("span.js-metro-line");
            if (!lines.isEmpty()) {
                for (Element line : lines) {
                    String lineNumber = line.attr("data-line");
                    String lineName = line.ownText();
                    builder.append(lineNumber).append(" - ").append(lineName).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}

