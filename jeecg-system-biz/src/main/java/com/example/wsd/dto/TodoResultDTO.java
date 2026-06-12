package com.example.wsd.dto;

import lombok.Data;

@Data
public class TodoResultDTO {
    private Long id;
    private String text;
    private boolean done;
}