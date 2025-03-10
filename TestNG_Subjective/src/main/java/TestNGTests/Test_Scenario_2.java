package TestNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utility.ConfigureClass;

public class Test_Scenario_2 extends ConfigureClass{

	
	@Test(timeOut = 20000)
    public void testScenario2_ClickCheckBox() {
        
        //1. Click “Checkbox Demo”
        WebElement checkboxDemoLink = driver.findElement(By.linkText("Checkbox Demo"));
        checkboxDemoLink.click();
        
        //2. Click the checkbox under the “Single Checkbox Demo” section
        WebElement singleCheckboxDemo = driver.findElement(By.id("isAgeSelected"));
        singleCheckboxDemo.click();
        
        //3. Validate whether this checkbox is “selected”
        Assert.assertTrue(singleCheckboxDemo.isSelected(), "Checkbox should be selected");
        
        //4. Now click the checkbox again and validate whether the checkbox is “unselected”
        singleCheckboxDemo.click();
        Assert.assertFalse(singleCheckboxDemo.isSelected(), "Checkbox should be unselected");
        
        System.out.println("Test Scenario 2 executed successfully");
    }
}
