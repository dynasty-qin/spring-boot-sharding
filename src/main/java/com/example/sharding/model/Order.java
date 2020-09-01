package com.example.sharding.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;

    private Long recordId;

    private Integer cost;

    private Date createTime;
}