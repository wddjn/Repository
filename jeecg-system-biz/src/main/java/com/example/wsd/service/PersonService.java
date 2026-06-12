package com.example.wsd.service;

import org.jeecg.common.system.base.service.JeecgService;
import com.example.wsd.entity.Person;

// 继承JeecgService，泛型是实体类
public interface PersonService extends JeecgService<Person> {
}