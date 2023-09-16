package ru.infoza.json;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSizeTest {

    @Test
    void jsonFile_whenLoad_thenCompareSize() throws IOException {
        String filePath = "src/test/resources/first.json";
        Map<String, Object> map = JsonUtils.jsonFileToMap(filePath);
        assertEquals(map.size(),5);

    }
}
