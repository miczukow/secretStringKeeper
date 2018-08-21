package password.manager.files;

import com.opencsv.CSVWriter;
import password.manager.model.PasswordEntry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {

    public void write(String path, PasswordEntry entry) throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        CSVWriter writer = new CSVWriter(
                new FileWriter(file.getPath(), true),
                ';',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeNext(entry.toArray());
        writer.close();
    }
}
