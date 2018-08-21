package password.manager.files;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> read (String path) throws IOException;

}
