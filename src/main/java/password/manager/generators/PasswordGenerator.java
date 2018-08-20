package password.manager.generators;

public interface PasswordGenerator {
    String generate(int length);
    GeneratorType getType();
}
