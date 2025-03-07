package com.example.parfum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommandeCreationDto implements Serializable {

    private Long id;

    private Long userId;

    private List<Long> parfumesIds;

}
