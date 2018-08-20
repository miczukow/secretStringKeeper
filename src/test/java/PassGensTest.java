import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassGensTest{

    @Test
    public void testPassLength(){
        String pass1 = PassGens.passGenJustLetters(0);
        String pass2 = PassGens.passGenLettersAndDigits(10000);
        String pass3 = PassGens.passGenAllSymbols(10000);

        Assert.assertEquals(0, pass1.length());
        Assert.assertEquals(10000, pass2.length());
        Assert.assertEquals(10000, pass3.length());
    }

    @Ignore
    @Test
    public void testPassGenJustLetters(){
        System.out.println(PassGens.passGenJustLetters(5));
    }

    @Ignore
    @Test
    public void testPassGenLettersAndDigits(){
        System.out.println(PassGens.passGenLettersAndDigits(5));
    }

    @Ignore
    @Test
    public void testPassGenAllSymbols(){
        System.out.println(PassGens.passGenAllSymbols(5));
    }

}