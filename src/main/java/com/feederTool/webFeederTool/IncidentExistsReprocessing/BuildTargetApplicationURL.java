package com.feederTool.webFeederTool.IncidentExistsReprocessing;

/*
To prepare the url string for the next uuid coming from the process instance array and return it to the main target application process class
 */

import org.springframework.stereotype.Component;

@Component
public class BuildTargetApplicationURL {
    private static final String baseUrlMain = "https://baseUrl/?searchQuery=%5B%7B%22type%22:%22PIwithRootIncidents%22,IprocessInstanceIds%22,%22operator%22:%22eq%22,%22value%22:%22";
    private static final String baseUrlTail = "%22,%22&operation=SET_RETRIES";
    public String targetAppUrl(String oneUuid)  { return baseUrlMain + oneUuid + baseUrlTail;
    }
}
