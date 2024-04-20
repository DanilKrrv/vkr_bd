package com.example.vkrbd.controller;

import com.example.vkrbd.entity.UserEntity;
import com.example.vkrbd.exception.UserAlreadyExistException;
import com.example.vkrbd.exception.UserNotFoundException;
import com.example.vkrbd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь сохранен");
        } catch(UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping()
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch(UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }  catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    /*
    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }*/

}
