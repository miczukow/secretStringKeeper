package password.manager.files;

import org.junit.Test;
import password.manager.model.PasswordEntry;
import password.manager.model.PasswordFacade;

import java.io.IOException;

import static org.junit.Assert.*;
import static password.manager.generators.GeneratorType.*;

public class CSVFileWriterTest {

    @Test
    public void testWritingToFile() throws IOException {
        PasswordFacade passwordFacade = new PasswordFacade();
        FilesFacade filesFacade = new FilesFacade();
        filesFacade.writeFile("test.csv", passwordFacade.generatePassword(
                "poczta",
                "login",
                LETTERS_AND_DIGITS,
                10 ));
//        CSVFileWriter writer = new CSVFileWriter();
//        writer.write("test.csv" , passwordFacade.generatePassword("poczta", "login", RANDOM_SYMBOLS, 10 ));
    }

}