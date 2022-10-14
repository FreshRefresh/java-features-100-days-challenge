package com.example.ram.jacksondemo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonDemoApp {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        try {
//            objectMapper.writeValue(new File("target/car.json"), car);
            String carAsString = objectMapper.writeValueAsString(car);
            System.out.println(carAsString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Car {

        private String color;
        private String type;

        public Car(String color, String type) {
            this.color = color;
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public String getType() {
            return type;
        }
        // standard getters setters
    }
}
