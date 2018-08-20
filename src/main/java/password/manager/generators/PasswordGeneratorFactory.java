package password.manager.generators;

import static password.manager.generators.GeneratorType.*;

class PasswordGeneratorFactory {

    PasswordGenerator getGenerator(GeneratorType type) {

        if (type == LETTERS) {
            return new LettersPasswordGenerator();
        }

        if (type == LETTERS_AND_DIGITS){
            return new LettersAndDigitsPasswordGenerator();
        }

        if (type == RANDOM_SYMBOLS){
            return new RandomSymbolsPasswordGenerator();
        }

        throw new PasswordGeneratorException("No such generator");
    }
}