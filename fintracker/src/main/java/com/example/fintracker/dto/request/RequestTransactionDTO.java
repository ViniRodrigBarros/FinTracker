package com.example.fintracker.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.Data;
@Getter
@Setter
public class RequestTransactionDTO {

    private Integer user_id;
    private Float valor;
    private String categoria;
    private String tipo;
    private Data data;


}
