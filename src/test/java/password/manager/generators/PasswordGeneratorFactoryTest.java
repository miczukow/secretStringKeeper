package password.manager.generators;

import org.junit.Test;

public class PasswordGeneratorFactoryTest {

    @Test
    public void givenArrayOfGeneratorTypes_WhenFactoryIsCalled_GeneratorIsReturned() {
        GeneratorType[] generatorTypes = GeneratorType.values();
        PasswordGeneratorFactory passwordGeneratorFactory = new PasswordGeneratorFactory();


        for (GeneratorType generatorType : generatorTypes) {
            PasswordGenerator generator = passwordGeneratorFactory.getGenerator(generatorType);
            PasswordGeneratorAssertion.assertThat(generator)
                    .isNotNull()
                    .hasType(generatorType);
        }
    }
}
