package com.example.wsd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wsd.entity.Person;
import com.example.wsd.mapper.PersonMapper;
import com.example.wsd.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    // 手动重写冲突的方法，明确返回类型
    @Override
    public PersonMapper getBaseMapper() {
        return baseMapper;
    }
}