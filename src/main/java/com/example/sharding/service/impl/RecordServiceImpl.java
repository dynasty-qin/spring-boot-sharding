package com.example.sharding.service.impl;

import com.example.sharding.mapper.RecordMapper;
import com.example.sharding.model.Record;
import com.example.sharding.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : Harry
 * Description : RecordService
 * Date : 2020-08-31 9:33
 */
@Service
public class RecordServiceImpl implements RecordService {

    private final RecordMapper recordMapper;

    @Autowired
    public RecordServiceImpl(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    @Override
    public int addRecord(Record record) {
        return recordMapper.insert(record);
    }

    @Override
    public Record getRecordById(Long id) {

        return recordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Record> getAll() {

        List<Record> all = recordMapper.getAll();

        return all;
    }

    @Override
    public List<Record> connect() {

        List<Record> connect = recordMapper.connect();
        return connect;
    }

    @Override
    public Integer countRecord() {

        return recordMapper.countRecord();
    }

    @Override
    public List<Record> getByParkingId(Integer parkingId) {

        return recordMapper.getByParkingId(parkingId);
    }

    @Override
    public Record newRecord() {

        return recordMapper.newRecord();
    }
}
