package com.feederTool.webFeederTool.DataPreparations;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
/*
the representation of the table which contains the data for the graph on the front
keeps the process instance type ids and how many of them were processed at a given time
 */


@Entity
@Table
public class TypeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Timestamp insert_time;
    private String typeId;
    private  int typeCount;
    private  String mot;

    public TypeHistory() {
    }

    public TypeHistory(String typeId, int typeCount, String mot) {
        this.typeId = typeId;
        this.typeCount = typeCount;
        this.mot = mot;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getInsertTime() {
        return insert_time;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insert_time = insertTime;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public void setTypeCount(int typeCount) {
        this.typeCount = typeCount;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }


    public Long getId() {
        return id;
    }

    public String getTypeId() {
        return typeId;
    }

    public int getTypeCount() {
        return typeCount;
    }

    public String getMot() {
        return mot;
    }

    @Override
    public String toString() {
        return "TypeOverTime{" +
                "id=" + id +
                ", typeId='" + typeId + '\'' +
                ", typeCount=" + typeCount +
                ", mot='" + mot + '\'' +
                '}';
    }
}




