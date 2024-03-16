package com.example.demo.dao;

import com.example.demo.model.Person;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class QueryService {

    /**
     * 设置集合名称
     */
    private static final String COLLECTION_NAME = "person";

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询集合中的【全部】文档数据
     *
     * @return 全部文档列表
     */
    public Object findAll() {
        // 执行查询集合中全部文档信息
        List<Person> documentList = mongoTemplate.findAll(Person.class, COLLECTION_NAME);
        // 输出结果
        for (Person Person : documentList) {
            log.info("用户信息：{}", Person);
        }
        return documentList;
    }

    /**
     * 根据【文档ID】查询集合中文档数据
     *
     * @return 文档信息
     */
    public Person findById(String id) {
        // 设置查询的文档 ID
        // 根据文档ID查询集合中文档数据，并转换为对应 Java 对象
        Person Person = mongoTemplate.findById(id, Person.class, COLLECTION_NAME);
        // 输出结果
        log.info("用户信息：{}", Person);
        return Person;
    }

    // http://www.mydlq.club/article/85/

}
