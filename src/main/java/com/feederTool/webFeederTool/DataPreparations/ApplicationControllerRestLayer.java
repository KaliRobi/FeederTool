package com.feederTool.webFeederTool.DataPreparations;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.feederTool.webFeederTool.IncidentExistsReprocessing.IncidentExistsMainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// creating the API end points and sending the incoming data toward the service layer.
//  "/base" the main and only page, hosts the front end.
// "/api/v1/randomthings/types"  to server the chart on the front end.
// "/api/v1/randomthings/progressBar/" to give feedback about the reprocessing
// "/api/v1/randomthings/post" accepts  input from the front and send it to the service layer





@RestController
public class ApplicationControllerRestLayer {
    private final TypeIdServiceLayer typeIdServiceLayer;

    private final IncidentExistsMainProcess incidentExistsMainProcess;


    @Autowired
    public ApplicationControllerRestLayer(TypeIdServiceLayer typeIdServiceLayer, IncidentExistsMainProcess incidentExistsMainProcess) {
        this.typeIdServiceLayer = typeIdServiceLayer;
        this.incidentExistsMainProcess = incidentExistsMainProcess;

    }

    @GetMapping(path="/" )
    public ModelAndView index(HttpServletRequest request ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/feederTool/api/v3/typeHistory")
    public Iterable<TypeHistory> getServedData(){
        return typeIdServiceLayer.getH2Data();
    }

    @GetMapping(value = "/feederTool/api/v3/processingStatus")
    public Map<String, Object>  getProgressBarState(HttpSession session)  {
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("state", session.getAttribute("progressBar"));
        jsonObject.put("session", session.getId());
        return jsonObject;
    }

    @PutMapping(value = "/feederTool/api/v3/processingStatus")
    public void setProgressBarState(@RequestBody Map<String, String> map,  HttpSession session){
        String requestMode = map.get("response");
        if(requestMode.equals("ACK")){
            session.setAttribute("progressBar", "CLEAR");
        }
    }

    @PostMapping(path = "/feederTool/api/v3/processInput", produces = APPLICATION_JSON_VALUE)
    void CreateNewUuid(@RequestBody InboundAppData inboundAppData, HttpSession session) throws ClassCastException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, InterruptedException { /// take json and map it to uuid
        session.setAttribute("progressBar", "START");


        incidentExistsMainProcess.targetApplicationProcessInstanceUuidExecutor(ProcessInstanceIdsServiceServiceLayer
                        .ArrayToString(inboundAppData
                        .getOperationalData()
                        .get("processInstanceId").toString()),
                inboundAppData.getOperationalData().get("password").toString(),
                inboundAppData.getOperationalData().get("username").toString());
        typeIdServiceLayer.processTypeHandler(inboundAppData);

    }

    @GetMapping(value = "/feederTool/test")
    public void testFunction() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InterruptedException {
        List<String> newList = new ArrayList<>(Arrays.asList("This is where the input comes during test"));

        System.out.println("halo?");
        incidentExistsMainProcess.targetApplicationProcessInstanceUuidExecutor(newList, "password", "username" );



    }

}

