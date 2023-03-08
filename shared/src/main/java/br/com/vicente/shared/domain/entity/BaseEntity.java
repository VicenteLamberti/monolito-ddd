package br.com.vicente.shared.domain.entity;

import br.com.vicente.shared.domain.valueobject.IdValueObject;

import java.time.Instant;

public class BaseEntity {

    private IdValueObject id;
    private Instant createdAt;
    private Instant updatedAt;

    public BaseEntity() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
    public BaseEntity(IdValueObject id) {
        this.id = id;
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public IdValueObject getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
