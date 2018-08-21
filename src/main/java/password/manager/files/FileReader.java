package password.manager.files;

import password.manager.model.PasswordEntry;

import java.io.IOException;
import java.util.List;

public interface FileReader {

    List<String> read (String path) throws IOException;
    List<PasswordEntry> getPasswordEntries(String path) throws IOException;


}
