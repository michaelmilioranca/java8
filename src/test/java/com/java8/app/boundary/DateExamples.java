package com.java8.app.boundary;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateExamples {

    @Test
    void creatingLocalDate(){
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

    @Test
    void usingPeriodClass(){
        LocalDate bornDate = LocalDate.of(1992, Month.MARCH, 8);
        LocalDate today = LocalDate.now();
        Period period = Period.between(bornDate, today);
        System.out.println("You have " + period.getYears() + " years");
    }

    @Test
    void formattingDates(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(today.format(dateTimeFormatter));
    }

    @Test
    void usingDateAndTime(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        System.out.println(today.format(dateTimeFormatter));
    }

}
