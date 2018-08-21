package password.manager.files;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BufferedFileReader extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException{
        File file = getFile(path);
        List<String> list = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)){
            String line;
            while((line = scanner.nextLine()) != null){
                list.add(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
