package com.example.demo.dao;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class SaveService {

    /** 设置集合名称 */
    private static final String COLLECTION_NAME = "person";

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 存储【一条】用户信息，如果文档信息已经【存在就执行更新】
     *
     * @return 存储的文档信息
     */
    public Person save(Person person) {
        // 设置用户信息
        // 存储用户信息,如果文档信息已经存在就执行更新
        Person newUser = mongoTemplate.save(person, COLLECTION_NAME);
        // 输出存储结果
        log.info("更新存储的用户信息为：{}", newUser);
        return newUser;
    }

}

