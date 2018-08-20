package password.manager.generators;

import java.util.Random;

public class RandomSymbolsPasswordGenerator implements PasswordGenerator {
    @Override
    public String generate(int length) {
        String pass = "";
        Random generator = new Random();
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(94);
            pass += (char)(tmpInt + 33);
        }
        return pass;
    }

    @Override
    public GeneratorType getType() {
        return GeneratorType.RANDOM_SYMBOLS;
    }
}
