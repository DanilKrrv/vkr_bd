package com.example.vkrbd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attestation")
public class AttestationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "user_id") // ключ в бд
    private UserEntity user; // это связь в юзерэнтити в mappedBy = "user"

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public AttestationEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
