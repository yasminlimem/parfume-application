package com.example.parfum.controller;

import com.example.parfum.dto.CommandeCreationDto;
import com.example.parfum.model.Commande;
import com.example.parfum.model.Parfum;
import com.example.parfum.model.User;
import com.example.parfum.repository.CommandeRepository;
import com.example.parfum.repository.ParfumRepository;
import com.example.parfum.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@RequiredArgsConstructor
public class CommadeController {

    private final CommandeRepository commandeRepository;
    private final UserRepository userRepository;
    private final ParfumRepository parfumRepository;

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody CommandeCreationDto commandeCreationDto) {
        Commande commande = new Commande();

        User user = userRepository.findById(commandeCreationDto.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        commande.setUser(user);

        List<Parfum> parfums = parfumRepository.findAllById(commandeCreationDto.getParfumesIds());
        commande.setParfums(parfums);

        double totalPrice = 0D;

        for (Parfum parfum : parfums) {
            Double price = parfum.getPrice();
            double discountedPrice = (1 - (parfum.getDiscount() / 100)) * price;
            totalPrice += discountedPrice;
        }
        commande.setTotalPrice(totalPrice);

        Commande _commande = commandeRepository.save(commande);
        return ResponseEntity.ok(_commande);
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getCommandes() {
        List<Commande> commandes = commandeRepository.findAll();

        return ResponseEntity.ok(commandes);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Commande> updateCommande(@RequestBody CommandeCreationDto commandeCreationDto) {
        Commande commande = commandeRepository.findById(commandeCreationDto.getId()).orElse(null);
        if (commande == null) {
            return ResponseEntity.notFound().build();
        }

        User user = userRepository.findById(commandeCreationDto.getUserId()).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        commande.setUser(user);

        List<Parfum> parfums = parfumRepository.findAllById(commandeCreationDto.getParfumesIds());
        commande.setParfums(parfums);

        double totalPrice = 0D;

        for (Parfum parfum : parfums) {
            Double price = parfum.getPrice();
            double discountedPrice = (1 - (parfum.getDiscount() / 100)) * price;
            totalPrice += discountedPrice;
        }
        commande.setTotalPrice(totalPrice);

        Commande _commande = commandeRepository.save(commande);
        return ResponseEntity.ok(_commande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
