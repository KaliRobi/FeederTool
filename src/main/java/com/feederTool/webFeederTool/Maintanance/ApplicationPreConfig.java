package com.feederTool.webFeederTool.Maintanance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


@Configuration
public class ApplicationPreConfig {

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("tool is up");
        };
    }

    @Bean
    public WebDriver webDriver(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    @Bean
    public WebDriverWait webDriverWait(){
        return new WebDriverWait(webDriver(), Duration.ofSeconds(10));

    }



}
