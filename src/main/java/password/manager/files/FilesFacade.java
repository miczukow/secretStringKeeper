package password.manager.files;

import password.manager.model.PasswordEntry;
import password.manager.model.PasswordFacade;

import java.io.IOException;
import java.util.List;

public class FilesFacade {

    private FileReader fileReader;
    private CSVFileWriter fileWriter;

    public FilesFacade(){
        fileReader = new LinesFileReader();
        fileWriter = new CSVFileWriter();
    }

    public List<String> readFile(String path){
        try{
            return fileReader.read(path);
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile(String path, PasswordEntry entry){
        try{
            fileWriter.write(path, entry);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeFile(String path, List<String> list){
        try{
            fileWriter.write(path, list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
