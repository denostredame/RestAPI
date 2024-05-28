package com.example.restapi.controller;

import com.example.restapi.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/main")
    public String mainListner() {
        return "Hello World";
    }

    @GetMapping("/api/cat")
    public String getCat() {
        Cat cat = new Cat("Барсик",2, 4);
        String jsonCat = null;
        try {
            jsonCat = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка Кота!!!");
        }

        return jsonCat;
    }

    @PostMapping("/api/addCat")
    public String getSpecialCat(@RequestParam String name,
                                @RequestParam int age,
                                @RequestParam int weight) {
        Cat cat = new Cat(name,age, weight);
        String jsonCat = null;
        try {
            jsonCat = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка Кота!!!");
        }

        return jsonCat;

    }

}
