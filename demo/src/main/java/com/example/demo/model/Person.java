package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
public class Person {
    @MongoId
    private String id;
    private BasicInfo basicInfo;
    private SchoolInfo schoolInfo;
}
