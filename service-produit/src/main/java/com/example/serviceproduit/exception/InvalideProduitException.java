package com.example.serviceproduit.exception;


/**
 * Exception lancée si on essaie d'ajouter un produit déjà enregistré avec le même numéro de produit
 */
public class InvalideProduitException extends Exception {

    public InvalideProduitException(String message) {
        super(message);
    }
}
