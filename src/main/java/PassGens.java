import java.util.Random;

public class PassGens {

    //Method generates password with given length containing just letters [a-zA-Z].
    public static String passGenJustLetters(int length){
        String pass="";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(52);
            if(tmpInt < 26)
                tmpCh = (char) (tmpInt + 65);
            else
                tmpCh = (char) (tmpInt - 26 + 97);
            pass += tmpCh;
        }
        return pass;
    }

    //Method generates password with given length containing letters and digits [a-zA-Z0-9].
    public static String passGenLettersAndDigits(int length){
        String pass = "";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(62);
            if(tmpInt < 26)
                tmpCh = (char) (tmpInt + 65);
            else if(tmpInt > 25 && tmpInt < 52)
                tmpCh = (char) (tmpInt - 26 + 97);
            else
                tmpCh = (char)(tmpInt - 52 + 48);
            pass += tmpCh;
        }
        return pass;
    }

    //Method generates password with given length containig letters, digits and other symbols ASCII 33-126
    public static String passGenAllSymbols(int length){
        String pass = "";
        Random generator = new Random();
        int tmpInt;

        for(int i = 0; i < length; ++i){
            tmpInt = generator.nextInt(94);
            pass += (char)(tmpInt + 33);
        }
        return pass;
    }
}
