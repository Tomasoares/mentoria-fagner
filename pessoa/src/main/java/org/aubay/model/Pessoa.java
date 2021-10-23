package org.aubay.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa extends PanacheEntity {

    public String nome;
    public String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    public Endereco endereco;

}
