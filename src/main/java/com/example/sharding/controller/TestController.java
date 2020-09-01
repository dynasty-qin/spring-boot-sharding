package com.example.sharding.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.sharding.model.Parking;
import com.example.sharding.model.Record;
import com.example.sharding.model.User;
import com.example.sharding.service.ParkingService;
import com.example.sharding.service.RecordService;
import com.example.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Author : Harry
 * Description : test
 * Date : 2020-08-28 14:55
 */
@RestController
public class TestController {

    private final UserService userService;
    private final RecordService recordService;
    private final ParkingService parkingService;

    @Autowired
    public TestController(UserService userService, RecordService recordService, ParkingService parkingService) {
        this.userService = userService;
        this.recordService = recordService;
        this.parkingService = parkingService;
    }

    @PostMapping(value = "/user/add")
    public String addUser() {

        User user = new User();
        user.setName(UUID.randomUUID().toString().replace("-", ""));

        LocalDateTime now = LocalDateTime.now().minusMonths(1L);
        System.out.println("用户创建时间 : " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        user.setCreateTime(date);
        userService.addUser(user);
        return "success";
    }

    @PostMapping(value = "/record/add")
    public String addRecord(@RequestParam Integer parkingId) {

        Record record = new Record();
        record.setName(UUID.randomUUID().toString().replace("-", ""));
        record.setCreateTime(new Date());
        record.setParkingId(parkingId);

        Snowflake snowflake = IdUtil.createSnowflake(30, 30);
        long id = snowflake.nextId();

        record.setId(id);
        recordService.addRecord(record);
        return "success";
    }

    @GetMapping(value = "/record/get")
    public String getRecordById(@RequestParam Long id) {
        return recordService.getRecordById(id).toString();
    }

    @GetMapping(value = "/record/getByParkingId")
    public List<Record> getRecordById(@RequestParam Integer parkingId) {
        return recordService.getByParkingId(parkingId);
    }

    @GetMapping(value = "/record/all")
    public List<Record> getAll() {
        return recordService.getAll();
    }

    @GetMapping(value = "/record/connect")
    public List<Record> connect() {
        return recordService.connect();
    }

    @GetMapping(value = "/record/count")
    public Integer countRecord() {
        return recordService.countRecord();
    }

    @GetMapping(value = "/record/new")
    public Record newRecord() {
        return recordService.newRecord();
    }

    @PostMapping(value = "/parking/add")
    public String add(@RequestParam String name) {

        Parking parking = new Parking();
        parking.setCreateTime(new Date());
        parking.setName(name);
        int add = parkingService.add(parking);
        return String.valueOf(add);
    }

    @GetMapping(value = "/parking/get")
    public Parking getParking(@RequestParam Integer parkingId) {
        return parkingService.getParking(parkingId);
    }
}
