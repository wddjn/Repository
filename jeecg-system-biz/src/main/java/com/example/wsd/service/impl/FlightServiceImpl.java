package com.example.wsd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wsd.entity.Flight;
import com.example.wsd.mapper.FlightMapper;
import com.example.wsd.service.FlightService;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl extends ServiceImpl<FlightMapper, Flight> implements FlightService {
    // 什么都不用写！继承ServiceImpl就自带了list、save、removeById等所有CRUD方法
}