package password.manager.view;

import password.manager.files.FilesFacade;
import password.manager.model.PasswordFacade;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static password.manager.generators.GeneratorType.LETTERS_AND_DIGITS;

public class AppView {

    public void appView() {
        int answear;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("1. Wygeneruj hasło i zapisz do pliku.");
            System.out.println("2. Wczytaj hasła z pliku.");
            System.out.println("3. Kopiuj hasło do schowka");
            System.out.println("0. Wyjście.");
//            answear = scanner.nextInt();
            while(true){
                try{
                    if((answear = Integer.parseUnsignedInt(scanner.nextLine())) >= 0 && answear <= 3) break;
                } catch (NumberFormatException e) {
                    System.out.println("Nieprawidłowa odpowiedź.");
                }
            }

            switch (answear){
                case 1:
                    add();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    copyToClipboard();
                    break;
                default:
                    break;
            }

        }while(answear != 0);
    }



    public void add(){
        Scanner sc = new Scanner(System.in);
        String website;
        String login;
        int length;

        System.out.flush();
        System.out.println("Podaj domenę:");
        website = sc.nextLine();
        System.out.println("Podaj login:");
        login = sc.nextLine();
        System.out.println("Podaj długość hasła:");
        while(true) {
            try {
                if ((length = Integer.parseUnsignedInt(sc.nextLine())) > 0) break;
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa odpowiedź.");
            }
        }

        PasswordFacade passwordFacade = new PasswordFacade();
        FilesFacade filesFacade = new FilesFacade();
        filesFacade.writeFile("test.csv", passwordFacade.generatePassword(
                website,
                login,
                LETTERS_AND_DIGITS,
                length));
    }

    public void read(){
        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        for (String line : list){
            System.out.println(line);
        }
    }

    private void copyToClipboard() {
        Scanner sc = new Scanner(System.in);
        String login, website;

        System.out.println("Podaj domenę:");
        website = sc.nextLine();
        System.out.println("Podaj login:");
        login = sc.nextLine();

        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        String[] entry;
        for (String line : list){
            entry = line.split(";");
            if(entry[0].equals(website) && entry[2].equals(login)){
//                System.out.println("Hasło dla "+entry[0]+" i loginu "+entry[2]);
                StringSelection selection = new StringSelection(entry[1]);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
            }
        }


    }
}


