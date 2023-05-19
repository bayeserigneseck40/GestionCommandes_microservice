package com.example.servicecommande.exception;


/**
 * Exception lancée si on essaie d'ajouter un client déjà enregistré avec le même numéro de carte
 */
public class InvalideClientException extends Exception {

    public InvalideClientException(String message) {
        super(message);
   
    }
}
