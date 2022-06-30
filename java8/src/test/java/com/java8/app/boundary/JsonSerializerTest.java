package com.java8.app.boundary;

import com.java8.app.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JsonSerializerTest {

    @Test
    void shouldSerializeObject() {
        JsonSerializer jsonSerializer = new JsonSerializer();

        final Car car = Car.builder()
                .company("BMW")
                .horsePower(433)
                .model("M3")
                .build();
        final var byteArray = jsonSerializer.serializeDataUsingJson(car);
        final var deserializedCar = jsonSerializer.deserializeUsingJson(byteArray);
        Assertions.assertEquals(car, deserializedCar);
    }

}