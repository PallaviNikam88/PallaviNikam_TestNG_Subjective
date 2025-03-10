package TestNGTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.ConfigureClass;

public class Test_Scenario_1 extends ConfigureClass{

	@Test(timeOut = 20000)
	 public void Test_01_WaitAndSoftAssert() {
        
        //1. Perform an explicit wait till the time all the elements in the DOM are available
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        
        //2. Use SoftAssert to validate the Page Title,Validate Against “LambdaTest”
        SoftAssert softAssert = new SoftAssert();
        AssertJUnit.assertEquals(driver.getTitle(), "LambdaTest");
        
        //( Proceed to the following statement)
        System.out.println("Test Scenario 1 executed successfully");
        
        // Assert all shows Failure
        softAssert.assertAll();
    }
	
}
