package org.aubay.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Endereco extends PanacheEntity {

    public String cep;
    public String bairro;

}
