package br.iesp.edu.api.resource;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponseModel {


    String property;
    String value;
    String error;


    ErrorResponseModel(String property,  String value, String message){
        this.error = message;
        this.value = value;
        this.property = property;
    }

    // getters, setters, and constructor
}