package br.com.vicente.shared.domain.valueobject;

import java.util.UUID;

public class IdValueObject implements ValueObject{

    private String id;

    private IdValueObject(final String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static IdValueObject from (final String id ){
        return new IdValueObject(id);
    }

    public static IdValueObject unique(){
        return new IdValueObject(UUID.randomUUID().toString());
    }
}
