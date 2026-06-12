package com.example.wsd.controller;

import com.example.wsd.entity.Person;
import com.example.wsd.service.PersonService;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/name")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public Result<List<Person>> list() {
        List<Person> list = personService.list();
        return Result.OK(list);
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Person person) {
        System.out.println("后端接收person:" + person);
        boolean ok = personService.save(person);
        return Result.OK(ok);
    }

    // 新增编辑PUT接口
    @PutMapping
    public Result<Boolean> update(@RequestBody Person person){
        boolean ok = personService.updateById(person);
        return Result.OK(ok);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        boolean ok = personService.removeById(id);
        return Result.OK(ok);
    }
}