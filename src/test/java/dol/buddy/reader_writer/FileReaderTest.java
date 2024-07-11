package dol.buddy.reader_writer;

import dol.buddy.addicted.Buddy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FileReaderTest {

    @Autowired
    private FileReader fileReader;

    @Test
    void readFile() throws IOException {
        Buddy fileContent = fileReader.readBuddy();
        String expected = "Anastazja";
        assertThat(expected).isEqualTo(fileContent.getName());
    }
}