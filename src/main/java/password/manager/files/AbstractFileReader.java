package password.manager.files;

import java.io.File;

public abstract class AbstractFileReader implements FileReader {

    protected File getFile(String path){
        if (path == null){
            throw new IllegalArgumentException("May not be null");
        }
        return new File(path);
    }


}
