package com.example.parfum.controller;

import com.example.parfum.dto.ParfumDto;
import com.example.parfum.model.Parfum;
import com.example.parfum.repository.ParfumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parfums")
@RequiredArgsConstructor
public class ParfumController {

    private final ParfumRepository parfumRepository;

    @PostMapping
    public ResponseEntity<Parfum> addParfum(@RequestBody ParfumDto parfumDto) {
        Parfum parfum = new Parfum();

        parfum.setPrice(parfumDto.getPrice());
        parfum.setCost(parfumDto.getCost());
        parfum.setName(parfumDto.getName());
        parfum.setDiscount(parfumDto.getDiscount());

        Parfum _parfum = parfumRepository.save(parfum);
        return ResponseEntity.ok(_parfum);
    }

    @GetMapping
    public ResponseEntity<List<Parfum>> getParfums() {
        List<Parfum> parfums = parfumRepository.findAll();

        return ResponseEntity.ok(parfums);
    }

    @PutMapping
    public ResponseEntity<Parfum> updateParfum(@RequestBody ParfumDto parfumDto) {
        Parfum parfum = parfumRepository.findById(parfumDto.getId()).orElse(null);
        if (parfum == null) {
            return ResponseEntity.notFound().build();
        }

        parfum.setPrice(parfumDto.getPrice());
        parfum.setCost(parfumDto.getCost());
        parfum.setName(parfumDto.getName());
        parfum.setDiscount(parfumDto.getDiscount());

        Parfum _parfum = parfumRepository.save(parfum);
        return ResponseEntity.ok(_parfum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParfum(@PathVariable Long id) {
        parfumRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
