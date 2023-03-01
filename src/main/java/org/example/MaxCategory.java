package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MaxCategory {
    public static void saveRequest(String request) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.bin", true))) {
            writer.println(request);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static Map.Entry<String, Long> maxCategory(String string) {
        HashMap<String, Long> map = new HashMap<>();
        JSONParser parser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.bin"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Object request = parser.parse(line);
                JSONObject purchase = (JSONObject) request;
                String cat = CategorySelect.getCategories((String) purchase.get("title"));
                long amount = (long) purchase.get("sum");

                if (map.containsKey(cat)) {
                    map.put(cat, map.get(cat) + amount);
                } else {
                    map.put(cat, amount);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return maxCat(map);
    }

    public static Map.Entry<String, Long> maxCat(HashMap<String, Long> map) {
        Map.Entry<String, Long> maxData = null;
        for (Map.Entry<String, Long> data : map.entrySet()) {
            if (maxData == null || data.getValue() > maxData.getValue()) {
                maxData = data;
            }
        }
        return maxData;
    }
}