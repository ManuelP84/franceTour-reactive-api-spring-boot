package com.sofka.franceTour.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class CyclistDTO {

    private String id = UUID.randomUUID().toString().substring(0, 3);

    private String cyclistId;

    private String name;

    private String teamId;
}
