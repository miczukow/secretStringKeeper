package password.manager.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;

public class BufferedFileReaderTest {

    @Test
    public void readFileAndPrint() throws IOException {
        String path = "C:\\Users\\RENT\\IdeaProjects\\secretStringKeeper\\src\\main\\resources\\test.txt";
        List<String> list = new BufferedFileReader().read(path);
        for(String line : list){
            System.out.println(line);
        }
    }

}