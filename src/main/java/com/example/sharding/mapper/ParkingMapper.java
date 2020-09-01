package com.example.sharding.mapper;

import com.example.sharding.model.Parking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ParkingMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Parking record);

    int insertSelective(Parking record);

    Parking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parking record);

    int updateByPrimaryKey(Parking record);
}