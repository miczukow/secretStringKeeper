package password.manager.generators;

public class PasswordGeneratorFacade {
    private PasswordGeneratorFactory passwordGeneratorFactory;

    public PasswordGeneratorFacade() {
        passwordGeneratorFactory = new PasswordGeneratorFactory();
    }

    public String getPassword(int length, GeneratorType type) {
        return passwordGeneratorFactory.getGenerator(type).generate(length);
    }
}
