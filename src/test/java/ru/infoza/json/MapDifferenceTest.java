package ru.infoza.json;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MapDifferenceTest {

    @Test
    void givenTwoJsonFiles_whenCompared_thenTheyAreDifferent() throws IOException {
        Map<String, Object> firstMap = JsonUtils.jsonFileToMap("src/test/resources/first.json");
        Map<String, Object> secondMap = JsonUtils.jsonFileToMap("src/test/resources/second.json");

        MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);
        difference.entriesDiffering().forEach((key, value) -> {
            System.out.println(key + ": " + value.leftValue() + " - " + value.rightValue());
        });
        assertFalse(difference.areEqual());
    }

    @Test
    void jsonFile_whenFlatten_thenCheck() throws IOException {
        Map<String, Object> flattenMap = FlattenUtils.flatten(JsonUtils.jsonFileToMap("src/test/resources/first.json"));
        assertEquals(flattenMap.get("children[1].age"),3);
    }

    @Test
    void givenTwoJsonFiles_whenComparedFlatten_thenTheyAreDifferent() throws IOException {
        Map<String, Object> firstFlatMap = FlattenUtils.flatten(JsonUtils.jsonFileToMap("src/test/resources/first.json"));
        Map<String, Object> secondFlatMap = FlattenUtils.flatten(JsonUtils.jsonFileToMap("src/test/resources/second.json"));

        MapDifference<String, Object> difference = Maps.difference(firstFlatMap, secondFlatMap);
        difference.entriesDiffering().forEach((key, value) -> {
            System.out.println(key + ": " + value.leftValue() + " - " + value.rightValue());
        });
        assertFalse(difference.areEqual());
    }

}
