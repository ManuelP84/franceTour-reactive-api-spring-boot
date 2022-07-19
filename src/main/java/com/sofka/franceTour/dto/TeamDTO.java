package com.sofka.franceTour.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class TeamDTO {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 3);

    private String name;

    private String country;

}
