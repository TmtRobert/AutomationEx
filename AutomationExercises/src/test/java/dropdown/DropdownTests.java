package dropdown;

import base.BaseTests;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        var dropDownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        Assertions.assertEquals(selectedOptions.size(),1,"incorrect number of selections");
        Assertions.assertTrue(selectedOptions.contains(option),"option not selected");


    }
}
