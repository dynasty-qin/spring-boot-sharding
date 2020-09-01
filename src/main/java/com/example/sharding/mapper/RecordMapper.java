package com.example.sharding.mapper;

import com.example.sharding.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    List<Record> getAll();

    List<Record> connect();

    Integer countRecord();

    List<Record> getByParkingId(@Param("parkingId") Integer parkingId);

    Record newRecord();
}