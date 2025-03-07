package com.example.parfum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoteDto implements Serializable {

    public Long id;

    private String name;

    private Double price;

    private Double pourcentage;

}
