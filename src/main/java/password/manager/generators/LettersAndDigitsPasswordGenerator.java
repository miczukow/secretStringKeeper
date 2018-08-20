package password.manager.generators;

import java.util.Random;

public class LettersAndDigitsPasswordGenerator implements PasswordGenerator {

    @Override
    public String generate(int length) {
        String pass = "";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(62);
            if(tmpInt < 26)
                tmpCh = (char) (tmpInt + 65);
            else if(tmpInt > 25 && tmpInt < 52)
                tmpCh = (char) (tmpInt - 26 + 97);
            else
                tmpCh = (char)(tmpInt - 52 + 48);
            pass += tmpCh;
        }
        return pass;
    }

    @Override
    public GeneratorType getType() {
        return GeneratorType.LETTERS_AND_DIGITS;
    }
}
