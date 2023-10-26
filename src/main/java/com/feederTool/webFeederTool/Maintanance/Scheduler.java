package com.feederTool.webFeederTool.Maintanance;

import com.feederTool.webFeederTool.DataPreparations.H2DatabaseHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

// The component is responsible for batch executions withing the tool.

@Component
public class Scheduler {


// this batch helps the data input consistent, should execute at 00:01 UTC
    @Scheduled(cron = "0 5 8 * * *")
    public void addAirEmptyRow() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        Timestamp strDate =  Timestamp.valueOf(dateFormat.format(new Date()));
        System.out.println(strDate);
        String queryAir = "INSERT INTO TYPE_HISTORY( insert_time, type_Id, type_Count, mot) VALUES( "+"'" + strDate + "'" +  ", 'AE000000000', 0, 'AE' ); ";
        String querySea = "INSERT INTO TYPE_HISTORY( insert_time, type_Id, type_Count, mot) VALUES( "+"'" + strDate + "'" +  ", 'SE000000000', 0, 'SE' ); ";
        H2DatabaseHandler.H2DatabaseInput(queryAir);
        H2DatabaseHandler.H2DatabaseInput(querySea);

    }



}
