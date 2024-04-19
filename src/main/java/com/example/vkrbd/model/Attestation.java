package com.example.vkrbd.model;

import com.example.vkrbd.entity.AttestationEntity;

public class Attestation {
    private Long id;
    private String title;
    private Boolean isValid;
    private String dataPassed;

    public String getDataPassed() {
        return dataPassed;
    }

    public void setDataPassed(String dataPassed) {
        this.dataPassed = dataPassed;
    }

    public static Attestation toModel(AttestationEntity entity) {
        Attestation model = new Attestation();
        model.setId(entity.getId());
        model.setIsValid(entity.getIsValid());
        model.setTitle(entity.getTitle());
        model.setDataPassed(entity.getDataPassed());
        return model;
    }


    public Attestation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}
