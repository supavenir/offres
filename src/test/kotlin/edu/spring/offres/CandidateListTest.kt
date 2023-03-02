package edu.spring.offres

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.openqa.selenium.chrome.ChromeDriver

@SpringBootTest
class CandidateListTest {
    @Test
    fun openWebPage() {
        System.getProperty("webdriver.chrome.driver", "src/main/kotlin/edu/spring/offres/drivers/chromedriver.exe");
        val driver : WebDriver = ChromeDriver();
    }
}