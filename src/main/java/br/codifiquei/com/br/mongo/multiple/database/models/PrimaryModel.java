package br.codifiquei.com.br.mongo.multiple.database.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "first_mongo")
public class PrimaryModel {

    @Id
    private String id;

    private Object o;
    private String value;

    public PrimaryModel(Object o, String value) {
        this.o = o;
        this.value = value;
    }

    @Override
    public String toString() {
        return "PrimaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}
