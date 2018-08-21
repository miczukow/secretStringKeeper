package password.manager.files;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class LinesFileReaderTest {

    @Test
    public void readFileAndPrint() throws IOException {
//        String path = "C:\\Users\\RENT\\IdeaProjects\\secretStringKeeper\\src\\main\\resources\\test.txt";
        String path = "test.txt";

        List<String> list = new BufferedFileReader().read(path);
        for(String line : list){
            System.out.println(line);
        }
    }

}