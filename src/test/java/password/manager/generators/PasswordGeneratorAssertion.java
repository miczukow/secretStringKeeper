package password.manager.generators;

import org.assertj.core.api.AbstractAssert;

class PasswordGeneratorAssertion extends AbstractAssert<PasswordGeneratorAssertion, PasswordGenerator> {

    private PasswordGeneratorAssertion(PasswordGenerator passwordGenerator) {
        super(passwordGenerator, PasswordGeneratorAssertion.class);
    }

    public static PasswordGeneratorAssertion assertThat(PasswordGenerator passwordGenerator) {
        return new PasswordGeneratorAssertion(passwordGenerator);
    }

    PasswordGeneratorAssertion hasType(GeneratorType type) {
        isNotNull();
        if (actual.getType() != type) {
            failWithMessage(String.format("Expected PasswordGenerator to have type %s but found %s", type, actual.getType()));
        }
        return this;
    }
}