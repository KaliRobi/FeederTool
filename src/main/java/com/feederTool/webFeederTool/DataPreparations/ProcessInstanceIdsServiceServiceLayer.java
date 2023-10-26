package com.feederTool.webFeederTool.DataPreparations;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

// The only reason this class is not merged to something is to keep it clear. (one class one purpose)

@Service
public class ProcessInstanceIdsServiceServiceLayer {
    public static List<String> ArrayToString(String list){
        return Arrays.asList(list.split(","));
    }

}
