package password.manager.model;

import password.manager.generators.GeneratorType;
import password.manager.generators.PasswordGeneratorFacade;

public class PasswordFacade {

    private PasswordGeneratorFacade passwordGeneratorFacade;

    public PasswordEntry generatePassword(String website, String login, GeneratorType strategy, int length) {
        String password = passwordGeneratorFacade.getPassword(length, strategy);
        return new PasswordEntry(website, password, login);
    }
}
