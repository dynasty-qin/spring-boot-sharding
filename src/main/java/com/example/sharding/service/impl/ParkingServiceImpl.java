package com.example.sharding.service.impl;

import com.example.sharding.mapper.ParkingMapper;
import com.example.sharding.model.Parking;
import com.example.sharding.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : Harry
 * Description :
 * Date : 2020-08-31 14:57
 */
@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingMapper parkingMapper;

    @Autowired
    public ParkingServiceImpl(ParkingMapper parkingMapper) {
        this.parkingMapper = parkingMapper;
    }

    @Override
    public int add(Parking parking) {

        return parkingMapper.insert(parking);
    }

    @Override
    public Parking getParking(Integer parkingId) {
        return parkingMapper.selectByPrimaryKey(parkingId);
    }
}
