package com.feederTool.webFeederTool.LocalProcessBuilder;

import com.feederTool.webFeederTool.IncidentExistsReprocessing.WorkWithElements;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class ProcessStep {


    private WebDriver webDriver;


    private final WebDriverWait hold;


    private WorkWithElements workWithElements;
    @Autowired
    public ProcessStep(WebDriver webDriver, WebDriverWait hold, WorkWithElements workWithElements) {
        this.webDriver = webDriver;
        this.hold = hold;
        this.workWithElements = workWithElements;
    }


    public ProcessStep(WebDriver webDriver, WebDriverWait hold) {
        this.webDriver = webDriver;
        this.hold = hold;

    }
     /*
      method: to navigate to one url.
      The method results the same as when we enter the url to the browsers address bar and hit enter.
      */
    public void navigateToThePage(String url){
        try{
            webDriver.navigate().to(new URI(url).toURL());
        } catch (URISyntaxException | MalformedURLException e ){
            throw new RuntimeException(e);
        }


    }
     /*
     method: to navigate to one url with feedback.
     The method results the same as when we enter the url to the browsers address bar and hit enter.
     Also provides a true - false value if we want to make sure the site is loaded and the chosen web element is present.
      */
    public boolean navigateToThePageWithFeedback(String url, String elementToCheck) {
        try{
            webDriver.navigate().to(new URI(url).toURL());
            return workWithElements.handleElement(elementToCheck, hold).isDisplayed();
        } catch (URISyntaxException | MalformedURLException e ) {
            throw new RuntimeException(e);
        }


    }

    /*
    method: enter a value to a field.
    The method results the same as when we type some value to an input element on the website (like a username, password)
    */
    public void enterValue(String xPath, String value) {
//      Extremely important safety feature, DO NOT remove!
        removeValue(xPath);
        workWithElements.handleElement(xPath, hold).sendKeys(value);
    }
    /*
    method: enter a value to a field.
    The method results the same as when we type some value to an input element on the website (like a username, password)
    */

    public void clickOnElement(String xPath){
        workWithElements.handleElement(xPath, hold).click();
    }

    public void removeValue(String xPath){
        workWithElements.handleElement(xPath, hold).clear();
    }

    public void waitALittle(String xPath, long millsToWait)  {
        try{
            workWithElements.handleElement(xPath, hold).wait(millsToWait);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    public boolean isDisplayed(String xPath){
        return workWithElements.handleElement(xPath, hold).isDisplayed();
    }

    public boolean isSelected(String xPath){
        return workWithElements.handleElement(xPath, hold).isSelected();
    }

    public boolean isEnabled(String xPath){
        try{
            System.out.println("uuid found: " +  workWithElements.handleElement(xPath, hold).isEnabled());
            return workWithElements.handleElement(xPath, hold).isEnabled();
        } catch (TimeoutException e){
            throw  new RuntimeException(e);
        }

    }




}
