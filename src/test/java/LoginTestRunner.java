import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test
    public void doUserLogin() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJsonArray(0);

        String username = login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(username.contains("test user"));

    }
    @Test
    public void loginWithInvalidEmail() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJsonArray(1);

        String errorMessage = login.loginWithInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Invalid email address"));

    }

    @Test
    public void loginWithInvalidPassword() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJsonArray(2);

        String errorMessage = login.loginWithInvalidPassword(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Authentication failed"));
    }
}
