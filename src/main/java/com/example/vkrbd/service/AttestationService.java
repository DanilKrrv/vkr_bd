package com.example.vkrbd.service;

import com.example.vkrbd.entity.AttestationEntity;
import com.example.vkrbd.entity.UserEntity;
import com.example.vkrbd.model.Attestation;
import com.example.vkrbd.repository.AttestationRepo;
import com.example.vkrbd.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttestationService {
    @Autowired
    private AttestationRepo attestationRepo;
    @Autowired
    private UserRepo userRepo;

    public Attestation createAttestation(AttestationEntity attestation, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        attestation.setUser(user);
        return Attestation.toModel(attestationRepo.save(attestation));
    }

    public Attestation completeAttestation(Long id) {
        AttestationEntity attestation = attestationRepo.findById(id).get();
        attestation.setIsValid(!attestation.getIsValid());
        return Attestation.toModel(attestationRepo.save(attestation));
    }

    public Long deleteAttestation(Long id){
        attestationRepo.deleteById(id);
        return id;
    }

}
