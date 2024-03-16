package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.model.BasicInfo;
import com.example.demo.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final InsertService insertService;
    private final QueryService queryService;
    private final SaveService saveService;

    @PutMapping("/person")
    @ResponseBody  //fronted have add the axios
    public ResponseEntity<String> putPerson(@RequestBody Person person) {
//        log.info("get person {}",person.toString());
        String id = "";
        if(person.getId()!=null) {
            Person updated = saveService.save(person);
            id = updated.getId();
        }else {
            id = insertService.insert(person).getId();
        }
        HttpHeaders headers = new HttpHeaders();
        log.info("insert person {} into db with id {}",person, id);
        ResponseEntity<String> entity = new ResponseEntity<>(id,headers, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/person/{id}")
    @ResponseBody  //fronted have add the axios
    public ResponseEntity<Person> getPerson(@PathVariable(value = "id") String id, @RequestHeader(value = "User-Agent") String userAgent) {
        Person person = queryService.findById(id);
        log.info("find person {} with id {}",person, id);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Person> entity = new ResponseEntity<>(person,headers, HttpStatus.OK);
        return entity;
    }
}
