package com.example.fintracker.model;

import lombok.Data;

@Data
public class OpenFinanceAPI {
    private Long id;
    private Long accountid;
    private String date;
    private String type;
    private String amount;
    private String category;

}