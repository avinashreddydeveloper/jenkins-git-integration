package com.gradle.poc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradle.poc.model.Student;
import com.gradle.poc.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SpringBootExampleApplication {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = {"/hello", "/test"})
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello world!!", HttpStatus.OK);
    }

    @GetMapping(path = {"/student/{id}"})
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentRepository.getById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(student, headers, HttpStatus.OK);
    }

    @PostMapping(path = "/student")
    public ResponseEntity<String> saveStudent(@RequestBody Student data) {
        studentRepository.save(data);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody Student data) {
        studentRepository.save(data);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static void main(String[] args) {
        //library dependency API category
        ProjectAPrimary a = new ProjectAPrimary();
        a.projectAPublicAPI(new ObjectMapper());

        System.out.println("Hello World!!!");
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
}
