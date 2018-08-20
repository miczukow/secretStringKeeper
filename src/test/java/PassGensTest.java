import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassGensTest{

@Test
public void testPassLength(){
    String pass1 = PassGens.passGenJustLetters(10);
    String pass2 = PassGens.passGenLettersAndDigits(10);
    String pass3 = PassGens.passGenAllSymbols(10);

    Assert.assertEquals(10, pass1.length());
    Assert.assertEquals(10, pass2.length());
    Assert.assertEquals(10, pass3.length());
}

}