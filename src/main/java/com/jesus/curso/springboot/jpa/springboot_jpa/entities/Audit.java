package com.jesus.curso.springboot.jpa.springboot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Audit {

    @Column(name = "create_at")
    private LocalDateTime creatAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;
    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    @PrePersist
    public void prePersist() {
        System.out.println("Evento del ciclo de vida del entity pre-persist");
        this.creatAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento del ciclo de vida del entity pre-update");
        this.updateAt = LocalDateTime.now();
    }



    public void setCreatAt(LocalDateTime creatAt) {
        this.creatAt = creatAt;
    }



    public LocalDateTime getUpdateAt() {
        return updateAt;
    }



    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
