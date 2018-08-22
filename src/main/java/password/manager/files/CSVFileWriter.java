package password.manager.files;

import com.opencsv.CSVWriter;
import password.manager.model.PasswordEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class CSVFileWriter {

    private static String PATH = "C:\\PasswordManager\\storage";

    public void write(String path, PasswordEntry entry) throws IOException{
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource(path).getFile());

        CSVWriter writer = new CSVWriter(
                new FileWriter(Paths.get(PATH + "\\" + path).toFile(), true),
                ';',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeNext(entry.toArray());
        writer.close();
    }

    public void write(String path, List<String> list) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        CSVWriter writer = new CSVWriter(
                new FileWriter(Paths.get(PATH + "\\" + path).toFile(), false),
                ';',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] tmpStrArr;
        for(String line : list){
            tmpStrArr = line.split(";");
            writer.writeNext(tmpStrArr);
        }
        writer.close();
    }


}
