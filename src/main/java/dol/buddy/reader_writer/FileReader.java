package dol.buddy.reader_writer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dol.buddy.addicted.Buddy;
import dol.buddy.addicted.BuddySoul;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
public class FileReader {

    @Value("${file.path}")
    private String path;

    private final ObjectMapper objectMapper;

    public FileReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Buddy readBuddy() throws IOException {
        File file = new ClassPathResource(path).getFile();
        JsonNode jsonNode = objectMapper.readTree(file);
        return readBuddy(jsonNode);
    }

    private Buddy readBuddy(JsonNode jsonNode) {
        return new Buddy.BuddyBuilder()
                .withId(jsonNode.get("id").asLong())
                .withName(jsonNode.get("name").asText())
                .withAge(jsonNode.get("age").asLong())
                .withMood(jsonNode.get("mood").asLong())
                .withAlive(jsonNode.get("alive").asBoolean())
                .withMoney(jsonNode.get("money").asLong())
                .build();
    }

    public BuddySoul readSoul(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (BuddySoul) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
