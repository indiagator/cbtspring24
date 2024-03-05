package com.cbt.cbtspring24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cbtspring24Application
{
    public static void main(String[] args) // WE HAVE LOST CONTROL OF THE MAIN METHOD | THIS IS CALLED IoC - Inversion of Control
    {
        SpringApplication.run(Cbtspring24Application.class, args);
    }
}
