package com.example.haruta.myapplication.model;

import lombok.Data;

@Data
public class Item {
    private int id;
    private String body;
    private String created_at;
    private String updated_at;
}