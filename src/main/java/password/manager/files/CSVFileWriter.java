package password.manager.files;

import com.opencsv.CSVWriter;
import password.manager.model.PasswordEntry;

import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {

    public void write(String path, PasswordEntry entry) throws IOException{
        CSVWriter writer = new CSVWriter(
                new FileWriter(path, true),
                ';',
                CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        writer.writeNext(entry.toArray());
        writer.close();
    }
}
