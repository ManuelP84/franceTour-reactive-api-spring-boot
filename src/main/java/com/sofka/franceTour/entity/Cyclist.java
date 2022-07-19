package com.sofka.franceTour.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "cyclist")
public class Cyclist {


    @Id
    private String id;

    private Integer cyclistId;

    private String name;

    private String teamId;
}
