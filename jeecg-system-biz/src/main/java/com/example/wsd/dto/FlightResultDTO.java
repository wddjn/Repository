package com.example.wsd.dto;

import lombok.Data;

@Data
public class FlightResultDTO {
    private Long id;
    private String start;
    private String end;
    private String time;
    private String price;
}