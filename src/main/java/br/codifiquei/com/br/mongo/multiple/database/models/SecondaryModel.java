package br.codifiquei.com.br.mongo.multiple.database.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "second_mongo")
public class SecondaryModel {


    @Id
    private String id;

    private Object o;
    private String value;

    public SecondaryModel(Object o, String value) {
        this.o = o;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SecondaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}