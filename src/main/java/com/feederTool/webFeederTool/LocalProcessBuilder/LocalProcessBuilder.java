package com.feederTool.webFeederTool.LocalProcessBuilder;

import com.feederTool.webFeederTool.IncidentExistsReprocessing.WorkWithElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
The purpose of this package to make the process building fairly easy and intuitive knowing only the methods of one class;
 */

@Component
public class LocalProcessBuilder {


    private WorkWithElements workWithElements;


    public void logout(WebDriver webDriver, WebDriverWait hold){
        ProcessStep processStep = new ProcessStep(webDriver, hold);
        processStep.clickOnElement("/html/body/div[1]/nav/ul/li[44]/a");
        processStep.clickOnElement("/html/body/div[1]/nav/ul/li[22]/ul/li[9]/a");
    }

    //Easy to create a list of steps what the tool needs to done on the target application's UI
    public void executeProcessChainName(WebDriver webDriver, WebDriverWait hold, String targetLocationString)  {
        ProcessStep processStep = new ProcessStep(webDriver, hold, workWithElements);
        processStep.navigateToThePage(targetLocationString);
        processStep.enterValue("/html/body/div/form/div[10]/div/input", "1");
        if(processStep.isDisplayed("/html/body/tr/td[3]/input")){
            processStep.clickOnElement("/html/body/tr/td[21]/input");
            if(processStep.isEnabled("/html/body/div[2]/button")){
                processStep.clickOnElement("/html/body/div[22]/div/button");
                processStep.clickOnElement("/html/body/div[4]/div/div[3]/button");
                processStep.clickOnElement("/html/body/div[123]/div/div[3]/div/section[9]/div/div/div[33]/div/a");
            }
        }

    }

    //

//    public void NEWPROCESSCHAINMETHOD(WebDriver webDriver, WebDriverWait hold, String targetLocationString) {
//        ProcessStep processStep = new ProcessStep(webDriver, hold);
//        processStep.navigateToThePage(targetLocationString);
//
//        }
//    }

}
