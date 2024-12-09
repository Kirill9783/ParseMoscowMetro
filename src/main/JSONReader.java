import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JSONReader {
    public String getStationsAndLine(String path) throws Exception {

        StringBuilder builder = new StringBuilder();

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(path));
        JSONObject metroJsonObject = (JSONObject) object;
        JSONObject stationsObj = (JSONObject) metroJsonObject.get("stations");
        stationsObj.keySet().forEach(k -> {
            JSONArray stationsArray = (JSONArray) stationsObj.get(k);
            builder.append("Линия: ").append(k).append(". Количество станций: ").append(stationsArray.size())
                    .append(". Название станций: ").append(stationsArray).append("\n");
        });
        return builder.toString();
    }
}


