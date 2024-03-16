package com.example.demo.dao;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class InsertService {

    /** 设置集合名称 */
    private static final String COLLECTION_NAME = "person";

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入【一条】文档数据，如果文档信息已经【存在就抛出异常】
     *
     * @return 插入的文档信息
     */
    public Person insert(Person person) {
        // 设置用户信息
        //...
        // 插入一条用户数据，如果文档信息已经存在就抛出异常
        Person newPerson = mongoTemplate.insert(person, COLLECTION_NAME);
        // 输出存储结果
        log.info("存储的用户信息为：{}", newPerson);
        return newPerson;
    }

}

