package com.example.vkrbd.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String FIO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<AttestationEntity> attestations;

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public List<AttestationEntity> getAttestations() {
        return attestations;
    }

    public void setAttestations(List<AttestationEntity> attestations) {
        this.attestations = attestations;
    }
}
