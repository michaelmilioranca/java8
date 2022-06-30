package com.java8.app.boundary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java8.app.model.Car;

import java.io.IOException;

public class JsonSerializer {

    public byte[] serializeDataUsingJson(Car car) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            final String objectAsJson = objectMapper.writeValueAsString(car);
            return objectAsJson.getBytes();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object", e);
        }
    }

    public Car deserializeUsingJson(final byte[] data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(data, Car.class);

        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize object", e);
        }
    }
}
