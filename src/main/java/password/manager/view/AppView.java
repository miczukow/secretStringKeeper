package password.manager.view;

import password.manager.files.FilesFacade;
import password.manager.generators.GeneratorType;
import password.manager.model.PasswordFacade;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class AppView {

    public void appView() {
        int answear;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("1. Wygeneruj hasło i zapisz do pliku.");
            System.out.println("2. Wczytaj hasła z pliku.");
            System.out.println("3. Kopiuj hasło do schowka");
            System.out.println("4. Usuń hasło");
            System.out.println("0. Wyjście.");
//            answear = scanner.nextInt();
            while(true){
                try{
                    if((answear = Integer.parseUnsignedInt(scanner.nextLine().trim())) >= 0 && answear <= 4) break;
                    else
                        System.out.println("Nieprawidłowa odpowiedź.");
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
                case 4:
                    removePassword();
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
        int genType;

        System.out.flush();
        System.out.println("Podaj domenę:");
        website = sc.nextLine().trim();
        System.out.println("Podaj login:");
        login = sc.nextLine().trim();
        System.out.println("Podaj długość hasła:");
        while(true) {
            try {
                if ((length = Integer.parseUnsignedInt(sc.nextLine().trim())) > 0 && length <= 100) break;
                else
                    System.out.println("Nie generuje tak długich haseł.");
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa odpowiedź.");
            }
        }

        System.out.println("Wybierz typ generatora:");
        for (int i = 0; i < GeneratorType.values().length; ++i) {
            System.out.println(i+": "+GeneratorType.values()[i]);
        }

        while(true) {
            try {
                if ((genType = Integer.parseUnsignedInt(sc.nextLine().trim())) >= 0 && genType < GeneratorType.values().length)
                    break;
                else
                    System.out.println("Nieprawidłowa odpowiedź.");
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa odpowiedź.");
            }
        }

        PasswordFacade passwordFacade = new PasswordFacade();
        FilesFacade filesFacade = new FilesFacade();
        filesFacade.writeFile("test.csv", passwordFacade.generatePassword(
                website,
                login,
                GeneratorType.values()[genType],
                length));
    }

    public void read(){
        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        String[] tmpStrArray;
        String tmpStr = "";
        for (String line : list){
            tmpStrArray = line.split(";");
            for(int i = 0; i < tmpStrArray[1].length(); ++i)
                tmpStr += '*';
            System.out.println(tmpStrArray[0]+"; "+tmpStrArray[2]+"; "+tmpStr);
            tmpStr = "";
        }
    }

    private void copyToClipboard() {
        Scanner sc = new Scanner(System.in);
        String login, website;

        System.out.println("Podaj domenę:");
        website = sc.nextLine().trim();
        System.out.println("Podaj login:");
        login = sc.nextLine().trim();

        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        String[] entry;
        boolean found = false;
        for (String line : list){
            entry = line.split(";");
            if(entry[0].equals(website) && entry[2].equals(login)){
//                System.out.println("Hasło dla "+entry[0]+" i loginu "+entry[2]);
                StringSelection selection = new StringSelection(entry[1]);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
                found = true;
            }
        }
        if (found == false)
            System.out.println("Hasło dla podanych domeny i loginu nie istnieje");
    }

    private void removePassword() {
        Scanner sc = new Scanner(System.in);
        String login, website;

        System.out.println("Podaj domenę:");
        website = sc.nextLine().trim();
        System.out.println("Podaj login:");
        login = sc.nextLine().trim();

        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        String[] entry;
        String line;
        int index = -1;
        for (int i = 0; i < list.size(); i++){
            line = list.get(i);
            entry = line.split(";");
            if(entry[0].equals(website) && entry[2].equals(login)) {
                index = i;
            }
        }

        if(index != -1)
            list.remove(index);
        else
            System.out.println("Hasło dla podanych domeny i loginu nie istnieje");
        filesFacade.writeFile("test.csv", list);
//        for(String li : list){
//            System.out.println(li);
//        }
    }
}


