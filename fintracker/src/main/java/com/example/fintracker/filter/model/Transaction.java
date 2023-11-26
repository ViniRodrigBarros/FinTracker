package com.example.fintracker.filter.model;

import jakarta.persistence.*;
import lombok.*;


import javax.xml.crypto.Data;

@Entity
@Table(name = "transacao")
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private long id;

    @Column(name = "user_id",nullable = false)
    private Integer user_id;

    @Column(name = "valor",nullable = false)
    private Float valor;

    @Column(name = "categoria",nullable = true)
    private String categoria;

    @Column(name = "tipo",nullable = true)
    private String tipo;

    //@Column(name = "data",nullable = false)
    //private Data data;

    @Builder
    public Transaction(Integer user_id, Float valor, String categoria, String tipo, Data data) {
        this.user_id = user_id;
        this.valor = valor;
        this.categoria = categoria;
        this.tipo = tipo;
        //this.data = data;
    }
}
