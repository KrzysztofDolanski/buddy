package dol.buddy.reader_writer;

import dol.buddy.addicted.BuddySoul;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Slf4j
public class FileWriter {

    public void writeSoul(BuddySoul buddySoul, String uuid) {
        try (FileOutputStream fos = new FileOutputStream("soul"+uuid);
                ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(buddySoul);
        } catch (IOException e) {
            log.warn("Soul file{} not saved: " + e.getMessage(), buddySoul.getUuid());
        }
    }

}
