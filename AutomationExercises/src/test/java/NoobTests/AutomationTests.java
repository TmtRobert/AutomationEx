package NoobTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AutomationTests {
    private WebDriver driver;

    @BeforeAll
    public static void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUp(){
      driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    @Order(1)
    public void newUserSignupVisible(){
         driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
         WebElement form = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        Assertions.assertTrue(form.isDisplayed(), "'New User sign up' text is not visible ");
    }
    @Test
    @Order(2)
    public void registerUser() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Robert");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("tau@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        WebElement form2 = driver.findElement(By.cssSelector("h2.title.text-center:first-of-type"));
        Assertions.assertTrue(form2.isDisplayed(), "ENTER ACCOUNT INFORMATION text is not visible");
        driver.switchTo().defaultContent();
        js.executeScript("window.scrollBy(0, 400)");
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("U87eCcUeWU@us");
        WebElement days = driver.findElement(By.id("days"));
        WebElement months = driver.findElement(By.id("months"));
        WebElement years = driver.findElement(By.id("years"));
        Select dropdownDays = new Select(days);
        Select dropdownMonths = new Select(months);
        Select dropdownYears = new Select(years);
        dropdownDays.selectByValue("10");
        dropdownMonths.selectByValue("10");
        dropdownYears.selectByValue("1996");

        driver.findElement(By.cssSelector("input[type='checkbox'][name='newsletter']")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Robert");
        driver.findElement(By.id("last_name")).sendKeys("Robert");
        driver.findElement(By.id("company")).sendKeys("Luftansa");
        driver.findElement(By.id("address1")).sendKeys("Steagului");
        driver.findElement(By.id("address2")).sendKeys("TotSteagului");
        WebElement dropdown = driver.findElement(By.id("country"));
        Select dropdownCountry = new Select(dropdown);
        dropdownCountry.selectByValue("Canada");
        driver.findElement(By.id("state")).sendKeys("Romania");
        driver.findElement(By.id("city")).sendKeys("Constanta");
        driver.findElement(By.id("zipcode")).sendKeys("900796");
        driver.findElement(By.id("mobile_number")).sendKeys("0753675234");
        js.executeScript("window.scrollBy(0, 300)");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
    }
    @Test
    @Order(9)
    public void loginUserWithCorrectUsernameAndPasswordAndDeleteAccountCreated(){
        /* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible*/
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("tau@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("U87eCcUeWU@us");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
    }
    @Test
    @Order(3)
    public void loginUserWithIncorrectUsernameAndPassword(){
        WebElement body = driver.findElement(By.xpath("/html/body"));
        Assertions.assertTrue(body.isDisplayed(),"Home page is not visible succesfully");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        WebElement form =driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2"));
        Assertions.assertTrue(form.isDisplayed(),"It;s not displayed");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("asgvdggd@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("Thisisnottheactualpassword");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        WebElement formIncorrectPassword =driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
        Assertions.assertTrue(formIncorrectPassword.isDisplayed(),"Nu apare boss");
    }
    @Test
    @Order(4)
    public void logoutUser(){
        WebElement body = driver.findElement(By.xpath("/html/body"));
        Assertions.assertTrue(body.isDisplayed(),"Home page is not visible succesfully");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        WebElement form =driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2"));
        Assertions.assertTrue(form.isDisplayed(),"It;s not displayed");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("tau@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("U87eCcUeWU@us");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assertions.assertTrue(loggedinAsUsername.isDisplayed(),"it s not displayed");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
       WebElement loginPage = driver.findElement(By.xpath("/html/body"));
       Assertions.assertTrue(loginPage.isDisplayed(),"itsnotdisplayed");
    }
    @Test
    @Order(5)
    public void contactUsForm(){
        /*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully*/
        WebElement body = driver.findElement(By.xpath("/html/body"));
        Assertions.assertTrue(body.isDisplayed(),"Home page is not visible succesfully");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
        WebElement getInTouch = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        Assertions.assertTrue(getInTouch.isDisplayed(),"'Get in touch' is not displayed");
        driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Robert");
        driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("tau@yahoo.com");
        driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("BUG REPORT");
        driver.findElement(By.id("message")).sendKeys("Login page is bugged");

        String filePath = "C:\\Recovery.txt";
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
        fileInput.sendKeys(filePath);
        driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).click();

        // Se așteaptă până când alerta este prezentă
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Acceptați alerta (faceți clic pe butonul "OK")
        alert.accept();

        WebElement formSucces = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
        Assertions.assertTrue(formSucces.isDisplayed(),"It is not displayed");
        WebElement clickHomeButton = driver.findElement(By.xpath("//*[@id=\"form-section\"]/a/span"));
        clickHomeButton.click();
        String expectedTitle = "Automation Exercise - Contact Us";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle,"Failed to land on homepage");

    }
//    @Test
//    @Order(6)
//    public void add_products_in_cart() {
//        /* 1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
//        4. Click 'Products' button
//        5. Hover over first product and click 'Add to cart'
//        6. Click 'Continue Shopping' button
//        7. Hover over second product and click 'Add to cart'
//        8. Click 'View Cart' button
//        9. Verify both products are added to Cart
//        10. Verify their prices, quantity and total price*/
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement clickProductsButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
//        clickProductsButton.click();
//
//        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//        for (WebElement iframe : iframes) {
//            try {
//                driver.switchTo().frame(iframe);
//                // Realizează acțiunile dorite în interiorul fiecărui iframe, excludând reclamele
//                // ...
//                driver.switchTo().defaultContent(); // Revin la contextul principal
//            } catch (NoSuchElementException e) {
//                // Reclamă - trecem la următorul iframe
//
//            }
//        }
//
//        js.executeScript("window.scrollBy(0, 400)");
//        WebElement firstProduct = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(firstProduct).perform();
//
//        WebElement addToCart = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
//        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div")));
//        addToCart.click();
//    }

}
