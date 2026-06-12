package com.example.wsd.dto;

import lombok.Data;

@Data
public class TodoCreateDTO {
    private String text;
    private boolean done;
}