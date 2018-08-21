package password.manager.files;

import java.io.IOException;
import java.util.List;

public class FilesFacade {

    private FileReader fileReader;

    public FilesFacade(){
        fileReader = new LinesFileReader();
    }

    public List<String> readFile(String path){
        try{
            return fileReader.read(path);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
