package password.manager;

import password.manager.generators.GeneratorType;
import password.manager.generators.PasswordGeneratorFacade;
import password.manager.view.AppView;

import java.io.IOException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        AppView view = new AppView();
        view.appView();
    }
}
