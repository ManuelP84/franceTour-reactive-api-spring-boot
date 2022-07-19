package com.sofka.franceTour.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "team")
public class Team {

    @Id
    private String id;

    private String name;

    private String country;


}
