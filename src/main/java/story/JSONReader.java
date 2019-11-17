package story;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

class JSONReader<T> {
    private ObjectMapper objectMapper;


    JSONReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    T read(String fullName, Class<T> clazz) {
        T object = null;
        try {
            object = objectMapper.readValue(
                        Objects.requireNonNull(this.getClass().getClassLoader()
                            .getResourceAsStream(fullName)), clazz);
        } catch (IOException exception) {
            exception.printStackTrace();
            System.exit(1);
        }

        return object;
    }
}
