package com.example.sharding.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    private Long id;

    private String name;

    private Integer parkingId;

    private Date createTime;

}