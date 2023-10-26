package com.feederTool.webFeederTool.DataPreparations;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


import java.util.Map;

 // the representation of the incoming data from the front end

@Component
public class InboundAppData {
    private final Map<String, Object> operationalData;

    public InboundAppData(@JsonProperty("operationValue") Map<String, Object> operationalData) {
        this.operationalData = operationalData;
    }

    public Map<String, Object> getOperationalData() {
        return operationalData;
    }

    @Override
    public String toString() {
        return "IncomingAppData{" +
                "operationalData=" + operationalData +
                '}';
    }
}
