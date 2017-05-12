package com.example.haruta.myapplication.domain.exception;


public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
