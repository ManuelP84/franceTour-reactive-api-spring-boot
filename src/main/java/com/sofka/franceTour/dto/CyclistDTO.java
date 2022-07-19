package com.sofka.franceTour.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Data
public class CyclistDTO {

    @Autowired
    public Random random;

    private String id;

    private Integer cyclistId = random.nextInt(1000);

    private String name;

    private String teamId;
}
