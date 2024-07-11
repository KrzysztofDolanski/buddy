package dol.buddy.reader_writer;

import dol.buddy.addicted.BuddyService;
import dol.buddy.addicted.BuddySoul;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FileWriterTest {

    @Autowired
    private BuddyService buddyService;
    Set<String> set = new HashSet<>();
    List<String> list = new ArrayList<>();

    Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.charAt(1) > o2.charAt(1) ? 1 : o1.charAt(1) == o2.charAt(1)? 0 : 2;
        }
    };

    Set<String> treeSet = new TreeSet<>(comparator);

    private String one = "one";
    private String three = "three";
    private String two = "two";
    private String four = "four";
    private String five = "five";
    private String duck = "duck";

    @BeforeEach
    void setUp() {
        set.add(one);
        set.add(two);
        set.add(three);
        set.add(four);
        set.add(five);
        set.add(duck);

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(duck);
    }

    @AfterEach
    void clear() {
        set.clear();
        list.clear();
    }

    @Test
    void writeSoul() throws IOException {
        //given
        BuddySoul buddySoul = new BuddySoul(buddyService);
        String fileName = String.valueOf(buddySoul.uuid);
        FileWriter fileWriter = new FileWriter();

        //when
        fileWriter.writeSoul(buddySoul, fileName);

        //then
        FileReader reader = new FileReader("soul"+fileName);
        assertThat(reader.ready()).isTrue();
    }

    @Test
    void testIterator() {
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            set.add("some");
        }
    }

    @Test
    void testListIterator() {
        ListIterator<String> stringListIterator = list.listIterator();
        int number = 0;
        while (number < 2) {
            System.out.println(stringListIterator.next());
            stringListIterator.add("dasd");
            number++;
        }
    }


    @Test
    void descending() {
        list.sort(Collections.reverseOrder());
        System.gc();
    }
}