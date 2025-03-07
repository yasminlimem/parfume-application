package com.example.parfum.controller;

import com.example.parfum.dto.UserDto;
import com.example.parfum.model.User;
import com.example.parfum.repository.UserRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());

        User _user = userRepository.save(user);
        return ResponseEntity.ok(_user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok(users);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());
        user.setAddress(userDto.getAddress());

        User _user = userRepository.save(user);
        return ResponseEntity.ok(_user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
