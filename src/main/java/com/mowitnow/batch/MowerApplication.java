package com.mowitnow.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BatchConfig.class)
public class MowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MowerApplication.class, args);
    }
}