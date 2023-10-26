package com.feederTool.webFeederTool.IncidentExistsReprocessing;
import com.feederTool.webFeederTool.LocalProcessBuilder.LocalProcessBuilder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;


// main process to reprocess the uuids in target application.
@Component
public class IncidentExistsMainProcess {

    @Autowired
    private WebDriver webDriver;
    @Autowired
    private WebDriverWait hold;
    @Autowired
    private WorkWithElements workWithElements;
    private final BuildTargetApplicationURL buildTargetApplicationURL;
    private final LocalProcessBuilder processBuilder;
    public IncidentExistsMainProcess(BuildTargetApplicationURL buildTargetApplicationURL, LocalProcessBuilder processBuilder) {
        this.buildTargetApplicationURL = buildTargetApplicationURL;
        this.processBuilder = processBuilder;
    }


    public void targetApplicationProcessInstanceUuidExecutor(List<String>  processInstanceIds,
                                                             String password,
                                                             String username) throws InterruptedException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            System.out.println(!processInstanceIds.isEmpty());
            if (!processInstanceIds.isEmpty()) {

                webDriver.navigate().to("https://targetApp/login");

//TODO
//log in neeeds its own method in LocalProcessBuilder


                ///  TARGET APP LOGGIN

                workWithElements.handleElement("/html/body/div[2]/div/div[2]/div/form/input[1]", hold).sendKeys(username);

                workWithElements.handleElement("/html/body/div[2]/div/div[2]/div/form/input[2]", hold).sendKeys(password);

                workWithElements.handleElement("/html/body/div[2]/div/div[2]/div/form/button", hold).click();
                ;

                for(String processInstance :  processInstanceIds) {
                    System.out.println(processInstance);
                    String processInstanceUrl = buildTargetApplicationURL.targetAppUrl(processInstance);

                    processBuilder.executeProcessChainName(webDriver, hold, processInstanceUrl);
                }
                processInstanceIds.clear();
                processBuilder.logout(webDriver,hold);

                System.out.println("PROCESS IS DONE");
//                frontend
//                session.setAttribute("progressBar", "DONE");
                ;
            } else {

            }
        System.out.println("no actual functionality here just testing the endpoints");
        } catch (Throwable err){  // this should catch the concurrent.timeoutException when there is no enough slot in selenium grid

        }
//        processInstanceIds.clear();

    }
}
