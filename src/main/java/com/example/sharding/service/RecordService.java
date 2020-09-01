package com.example.sharding.service;

import com.example.sharding.model.Record;

import java.util.List;

/**
 * Author : Harry
 * Description : RecordService
 * Date : 2020-08-31 9:33
 */
public interface RecordService {

    int addRecord(Record record);

    Record getRecordById(Long id);

    List<Record> getAll();

    List<Record> connect();

    Integer countRecord();

    List<Record> getByParkingId(Integer parkingId);

    Record newRecord();
}
