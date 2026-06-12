package com.example.wsd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("flight")
public class Flight {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("flightNo")
    private String flightNo;
    @TableField("dep")
    private String dep;
    @TableField("arr")
    private String arr;
    @TableField("price")
    private BigDecimal price;
}