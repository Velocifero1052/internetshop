package com.example.internetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Calendar;

@SpringBootApplication
public class InternetshopApplication {

    public static void main(String[] args) {
       SpringApplication.run(InternetshopApplication.class, args);


    }

}
