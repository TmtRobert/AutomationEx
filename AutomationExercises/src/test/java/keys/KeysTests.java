package keys;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class KeysTests extends BaseTests {
    @Test
    public void testBackSpace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        Assertions.assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }
}
