package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class controller {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> hello(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    public ResponseEntity<?> bye(){
        return new ResponseEntity<>("Bye World!", HttpStatus.OK);
    }


}