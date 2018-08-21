package password.manager.files;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BufferedFileReader extends AbstractFileReader {

    @Override
    public List<String> read(String path) throws IOException{
        File file = getFile(path);
        List<String> result = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                result.add(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
