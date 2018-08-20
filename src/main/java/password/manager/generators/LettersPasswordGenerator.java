package password.manager.generators;

import java.util.Random;

public class LettersPasswordGenerator implements PasswordGenerator {

    @Override
    public String generate(int length){
        String pass = "";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(52);
            if(tmpInt < 26)
                tmpCh = (char) (tmpInt + 65);
            else
                tmpCh = (char) (tmpInt - 26 + 97);
            pass += tmpCh;
        }
        return pass;
    }

    @Override
    public GeneratorType getType(){
        return GeneratorType.LETTERS;
    }
}
