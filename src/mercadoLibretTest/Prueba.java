package mercadoLibretTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Prueba {
    @Test   (  priority = 1 , description = "Evalúa el título del documento")
    void PruebaTitle(){
        ChromeOptions chrome_options = new ChromeOptions(); //inyecta valores desde el momento en que se habre
        chrome_options.addArguments("--headless");


        System.setProperty( "webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe" );


        WebDriver driver = new ChromeDriver(chrome_options);

        driver.get("https://www.mercadolibre.com.ar/");


        Assert.assertEquals(driver.getTitle() , "Black Friday 2020");

    }
    @Test ( priority = 2,description = "saca screnshot a la pagina")
    void    pruebaScreen(){
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chrome\\chromedriver.exe");

        ChromeOptions chrome_options = new ChromeOptions();
        /// actualiza el valor negativo, puede que el browser aparezca fuera de tu pantalla

        chrome_options.addArguments("--window-position=0,0");
       chrome_options.addArguments("--window-size=800,500");

        WebDriver driver = new ChromeDriver(chrome_options);
        driver.get("https://www.mercadolibre.com.ar/");

        driver.manage().window().maximize();

        File src = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE );// tomo los datos del screnshot enviamos esos datos a un archivo

        try{    // almacenamos la screenshot
            FileUtils.copyFile( src , new File( "C:/selenium/imagen.png") );
        }catch ( IOException e){
            System.out.println(e.getMessage());
        }

    }
    /*@Test (priority = 3,description = "dar click en  'ayuda' ")
void pruebaClick(){
        ChromeOptions chrome_options = new ChromeOptions();
        //chrome_options.addArguments("--window-position=50,750");
        //chrome_options.addArguments("--window-size=max");
       chrome_options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chrome_options);
        driver.get("https://www.mercadolibre.com.ar/");

        WebElement boton =  driver.findElement(By.id("login"));

        boton.click();
        Alert alerta = driver.switchTo().alert();
        System.out.println( alerta.getText());

    }*/
}
