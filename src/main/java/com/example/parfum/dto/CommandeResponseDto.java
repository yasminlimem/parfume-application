package com.example.parfum.dto;

import com.example.parfum.model.Parfum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeResponseDto {

    private Long id;

    private UserDto user;

    private List<ParfumDto> parfums;

    private Double totalPrice;
}
