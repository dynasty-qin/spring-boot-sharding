package com.example.sharding.service;

import com.example.sharding.model.Parking;

/**
 * Author : Harry
 * Description : ParkingService
 * Date : 2020-08-31 14:57
 */
public interface ParkingService {

    int add(Parking parking);

    Parking getParking(Integer parkingId);
}
