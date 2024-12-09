package myOptions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class ParseJson {

    public String parseJson(String data) throws Exception {
        StringBuilder builder = new StringBuilder();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(data));
        for (Object object : jsonArray) {
            JSONObject stationIndo = (JSONObject) object;
            String station_name = (String) stationIndo.get("station_name");
            String depths = (String) stationIndo.get("depth");
            builder.append("Название станции: ").append(station_name).append("\n").append("Глубина: ").append(depths).append("\n");
        }
        return builder.toString();
    }
}
