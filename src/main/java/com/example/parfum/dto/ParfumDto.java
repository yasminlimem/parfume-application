package com.example.parfum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ParfumDto implements Serializable {

    public Long id;

    private String name;

    private Double price;

    private Double discount;

    private Double cost;

    private String url;
}
