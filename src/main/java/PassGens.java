import java.util.Random;

public class PassGens {

    //Method generates password with given length containing just letters [a-zA-Z].
    public static String passGenJustLetters(int lenght){
        String pass="";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < lenght; ++i){
            tmpInt = generator.nextInt(50);
            if(tmpInt > 25)
                tmpCh = (char) (tmpInt - 25 + 97);
            else
                tmpCh = (char) (tmpInt + 65);
            pass += tmpCh;
        }

        return pass;
    }

    //Method generates password with given length containing letters and digits [a-zA-Z0-9].
    public static String passGenLettersAndDigits(int lenght){
        String pass = "";
        Random generator = new Random();
        char tmpCh;
        int tmpInt;

        for(int i = 0; i < lenght; ++i){
            tmpInt = generator.nextInt(60);
            if(tmpInt < 26)
                tmpCh = (char) (tmpInt + 65);
            else if(tmpInt > 25 && tmpInt < 51)
                tmpCh = (char) (tmpInt - 25 + 97);
            else
                tmpCh = (char)(tmpInt - 50 + 48);
            pass += tmpCh;
        }
        return pass;
    }
}
