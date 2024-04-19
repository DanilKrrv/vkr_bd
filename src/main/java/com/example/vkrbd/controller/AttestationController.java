package com.example.vkrbd.controller;

import com.example.vkrbd.entity.AttestationEntity;
import com.example.vkrbd.service.AttestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attestations")
public class AttestationController {
    @Autowired
    private AttestationService attestationService;

    @PostMapping
    public ResponseEntity createAttestation(@RequestBody AttestationEntity attestation,
                                            @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(attestationService.createAttestation(attestation, userId));
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeAttestation(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(attestationService.completeAttestation(id));
        }  catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAttestation(@PathVariable Long id){
        try {
            return ResponseEntity.ok(attestationService.deleteAttestation(id));
        }  catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
