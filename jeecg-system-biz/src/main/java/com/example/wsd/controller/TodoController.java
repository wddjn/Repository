package com.example.wsd.controller;

import com.example.wsd.entity.Todo;
import com.example.wsd.service.TodoService;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public Result<List<Todo>> list() {
        List<Todo> list = todoService.list();
        return Result.OK(list);
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Todo todo) {
        System.out.println("后端接收todo:" + todo);
        boolean ok = todoService.save(todo);
        return Result.OK(ok);
    }
    // 编辑更新接口
    @PutMapping
    public Result<Boolean> update(@RequestBody Todo todo){
        boolean ok = todoService.updateById(todo);
        return Result.OK(ok);
    }
    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        boolean ok = todoService.removeById(id);
        return Result.OK(ok);
    }
}