package password.manager.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LinesFileReader extends AbstractFileReader{

    @Override
    public List<String> read(String path) throws IOException {
//        File file = getFile(path);
//        List<String> list = new ArrayList<>();
//        try{
//            list = Files.readAllLines(file.toPath());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        return Files.readAllLines(getFile(path).toPath());
    }
}
