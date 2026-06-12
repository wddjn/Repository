package com.example.wsd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wsd.entity.Todo;
import com.example.wsd.mapper.TodoMapper;
import com.example.wsd.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo>
        implements TodoService {
}