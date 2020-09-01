package com.example.sharding.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Date createTime;
}