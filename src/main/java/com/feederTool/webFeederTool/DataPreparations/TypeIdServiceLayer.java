package com.feederTool.webFeederTool.DataPreparations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//handles the data passed by the controller in regard to type ids
// adds it to db, also removes the old records what we dont need anymore

@Service
public class TypeIdServiceLayer   {

    public final TypesRepository typesRepository;

    @Autowired
    public TypeIdServiceLayer(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }


    public void processTypeHandler(InboundAppData inboundAppData) throws JsonProcessingException, NullPointerException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Integer> typeMap = objectMapper.readValue(inboundAppData.getOperationalData().get("typeMap").toString(),  new TypeReference<Map<String, Integer>>() {
        });
        List<TypeHistory> anotherSmt = new ArrayList<>();


        for( String type : typeMap.keySet()  ){
            TypeHistory typeHistory = new TypeHistory(type, typeMap.get(type), defineTypeMot(type) );
            anotherSmt.add(typeHistory);
        }

        passToTheDatabase( anotherSmt);
        H2DatabaseHandler.H2DatabaseInput("DELETE FROM TYPE_HISTORY WHERE insert_time < current_date - 30");

    }

    private void passToTheDatabase( List<TypeHistory> typeHistoryList) { //
            typesRepository.saveAll(typeHistoryList);

    }

    public  Iterable<TypeHistory> getH2Data(){
        return typesRepository.findAll();
    }

    private static String defineTypeMot(String instance){
        return instance.substring(0,2);
    }


}
