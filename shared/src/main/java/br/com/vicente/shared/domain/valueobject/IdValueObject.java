package br.com.vicente.shared.domain.valueobject;

import java.util.UUID;

public class IdValueObject implements ValueObject{

    private String id;

    public IdValueObject(final String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
