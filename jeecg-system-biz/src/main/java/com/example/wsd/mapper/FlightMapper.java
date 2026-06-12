package com.example.wsd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wsd.entity.Flight;
import org.apache.ibatis.annotations.Mapper;

@Mapper   // 重要！
public interface FlightMapper extends BaseMapper<Flight> {
}