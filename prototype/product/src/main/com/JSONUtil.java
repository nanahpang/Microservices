import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSONUtil {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJSON(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }

    public static <T> T fromJSON(String jsonStr, Class<T> pojoClass) throws IOException {
        return objectMapper.readValue(jsonStr, pojoClass);
    }

    public static Map<String, Object> parseMap(String jsonStr) throws IOException {
        return (jsonStr==null||jsonStr.isEmpty())? new HashMap(): objectMapper.readValue(jsonStr, Map.class);
    }
}