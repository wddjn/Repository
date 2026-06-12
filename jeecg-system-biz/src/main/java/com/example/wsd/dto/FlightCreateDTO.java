package com.example.wsd.dto;

import lombok.Data;

@Data
public class FlightCreateDTO {
    private String start;
    private String end;
    private String time;
    private String price;
}