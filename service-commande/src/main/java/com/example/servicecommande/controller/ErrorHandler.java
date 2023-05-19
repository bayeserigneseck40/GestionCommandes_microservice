package com.example.servicecommande.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.servicecommande.exception.ClientInconnuException;
import com.example.servicecommande.exception.CommandeInconnuException;
import com.example.servicecommande.exception.InvalideCommandeException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    private static final Map<String, String> error = new HashMap<>();

    /**
     * gestion erreur client inconnu
     * @param exception
     * @return
     */
    @ExceptionHandler(ClientInconnuException.class)
    public ResponseEntity handleEtudiantInconnuException(ClientInconnuException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    /**
     * gestion erreur commande invalide (information manquant ou mal formé)
     * @param exception
     * @return
     */
    @ExceptionHandler(InvalideCommandeException.class)
    public ResponseEntity handleInvalideMoyenneException(InvalideCommandeException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    /**
     * gestion erreur commande inconnue , cad commande inexistante pour un ID donné
     * @param exception
     * @return
     */
    @ExceptionHandler(CommandeInconnuException.class)
    public ResponseEntity handleMoyenneInconnuException(CommandeInconnuException exception) {
        error.put("erreur", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
