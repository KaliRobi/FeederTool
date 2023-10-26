package com.feederTool.webFeederTool.IncidentExistsReprocessing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// class is to simplify the code and shorten repetitive parts.

@Component
public class WorkWithElements {

    public WebElement handleElement(String path, WebDriverWait hold) {
        return hold.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
    }

}
