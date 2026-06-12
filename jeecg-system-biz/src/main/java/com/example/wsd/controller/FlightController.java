package com.example.wsd.controller;

import com.example.wsd.entity.Flight;
import com.example.wsd.service.FlightService;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/list")
    public Result<List<Flight>> list() {
        List<Flight> list = flightService.list();
        return Result.OK(list);
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Flight flight) {
        System.out.println("后端接收flight:" + flight);
        boolean ok = flightService.save(flight);
        return Result.OK(ok);
    }
    // 新增PUT编辑接口
    @PutMapping
    public Result<Boolean> update(@RequestBody Flight flight) {
        boolean ok = flightService.updateById(flight);
        return Result.OK(ok);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        boolean ok = flightService.removeById(id);
        return Result.OK(ok);
    }
}