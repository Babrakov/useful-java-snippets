package ru.infoza.json;

import java.io.IOException;
import java.util.Map;

/*
 Reading JSON Documents as Maps and Comparing Them
 https://www.baeldung.com/java-json-maps-comparison
 See details in the test package
 */
public class LoadJsonFile
{
    public static void main(String[] args) {
        String filePath = "src/test/resources/first.json";
        try {
            Map<String, Object> map = JsonUtils.jsonFileToMap(filePath);
            System.out.println(map.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
