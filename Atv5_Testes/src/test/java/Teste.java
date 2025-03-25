import com.google.common.io.ByteArrayDataInput;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.bidi.network.BytesValue;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Teste {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");
    }



    @Test
    public void findElementByOtherElement(){
        WebElement formElement = driver.findElement(By.id("basicBootstrapForm"));
        WebElement divElement = formElement.findElement(By.className("form-group"));
        WebElement labelElement = divElement.findElement(By.tagName("label"));
        WebElement inputElement = divElement.findElement(By.tagName("input"));

        inputElement.sendKeys("Ana");
        WebElement inputElementLastName = divElement.findElement(By.xpath("//input[@placeholder='Last Name']"));
        inputElementLastName.sendKeys("Villas");
        WebElement inputAdress = divElement.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        inputAdress.sendKeys("Teste");
        WebElement emailAdress = divElement.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        emailAdress.sendKeys("anaprimo@edu.unifil.br");
        WebElement phoneNumber = divElement.findElement(By.xpath("//input[@type='tel']"));
        phoneNumber.sendKeys("4384024432");

    }
    @Test
    public void radioButtonElement(){
        List<WebElement> elements = driver.findElements(By.name("radiooptions"));
        Assert.assertEquals(2, elements.size());

        WebElement radioElement = elements.get(1);
        radioElement.click();
        Assert.assertEquals("FeMale", radioElement.getAttribute("value"));
        Assert.assertTrue(radioElement.isSelected());

    }
    @Test
    public void selectCheckBocx(){
        WebElement element = driver.findElement(By.id("checkbox2"));
        element.click();
    }
    @Test
    public void selectElement (){
        WebElement element = driver.findElement(By.id("Skills"));
        Select selectionOption = new Select(element);

        selectionOption.selectByVisibleText("C");
        Assert.assertEquals("C", selectionOption.getFirstSelectedOption().getText());
    }
    // Professor, vou ser honesta, usei o gpt nessa parte aqui de esperar alguns segundos pra clicar. (obs: Coloquei isso no meio e bugou o teste, ta maluco)
    @Test
    public void multSelect(){
        WebElement multSelectTag = driver.findElement(By.tagName("multi-select"));
        WebElement labelMultSelect = multSelectTag.findElement(By.id("msdd"));
        WebElement list = multSelectTag.findElement(By.tagName("li"));
        WebElement selectMultiSelect = list.findElement(By.xpath("//li[@list-select='' and contains(@class, 'ng-scope')]/a[text()='Portuguese']"));
        labelMultSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@list-select='' and contains(@class, 'ng-scope')]/a[text()='Portuguese']")));
        selectMultiSelect.click();
    }
    @Test
    public void selectCountry(){
        WebElement formElement = driver.findElement(By.id("basicBootstrapForm"));
        WebElement divElement = formElement.findElement(By.className("form-group"));
        WebElement selectlabel = divElement.findElement(By.xpath("//label[@for='usr' and contains(text(), 'Select Country')]"));
        selectlabel.click();
        WebElement selectcountr = driver.findElement(By.id("country"));
        WebElement selectOption = selectcountr.findElement(By.tagName("option"));
        WebElement selectHongKong = selectOption.findElement(By.xpath("//select[@id='country']/option[@value='Hong Kong']"));
        selectHongKong.click();

       /* Essa coisa não funciona, não tem como dar submit
       WebElement selectCount2 = driver.findElement(By.id("countries"));
        WebElement selecOptionC = selectCount2.findElement(By.xpath("//option[text()='Select Country']"));
        selecOptionC.click(); */
    }
    @Test
    public void year(){
        WebElement yearElement = driver.findElement(By.id("yearbox"));
        yearElement.click();
        WebElement selectYear = yearElement.findElement(By.xpath("//select[@id='yearbox']/option[@value='2004']"));
        selectYear.click();
        WebElement monthElement = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        monthElement.click();
        WebElement selectMonth = monthElement.findElement(By.xpath("//select[@ng-model='monthbox']/option[@value='October']"));
        selectMonth.click();
        WebElement dateElement = driver.findElement(By.id("daybox"));
        WebElement selectDate = dateElement.findElement(By.xpath("//select[@id='daybox']/option[@value='8']"));
        selectDate.click();
    }
    @Test
    public void password(){
        WebElement passwordElementOne = driver.findElement(By.id("firstpassword"));
        passwordElementOne.sendKeys("Testando123!");
        WebElement passwordElementTwo = driver.findElement(By.id("secondpassword"));
        passwordElementTwo.sendKeys("Testando123!");

    }

 @Test
    public void submissionButton() {
        WebElement element = driver.findElement(By.id("submitbtn"));
        element.click();
    }

}
