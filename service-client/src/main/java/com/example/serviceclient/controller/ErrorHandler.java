package com.example.serviceclient.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.serviceclient.exception.ClientInconnuExecption;
import com.example.serviceclient.exception.InvalideClientException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    private static final Map<String, String> error = new HashMap<>();

    /**
     * fonction appelée pour gerer l'exception concernant l'ajout d'un client invalide
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalideClientException.class)
    public ResponseEntity handleInvalideEtudiantException(InvalideClientException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }


    /**
     * fonction appelée pour gerer l'exception concernant un client inconnu de la base de données lors de la modification ou de la suppression
     * @param exception
     * @return
     */
    @ExceptionHandler(ClientInconnuExecption.class)
    public ResponseEntity handleEtudiantInconnuException(ClientInconnuExecption exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
