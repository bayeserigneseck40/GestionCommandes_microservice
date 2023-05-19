package com.example.serviceclient.exception;

/**
 * Exception lancée si on essaie une modification sur un client qui n'existe pas
 */
public class ClientInconnuExecption extends Exception{
    public ClientInconnuExecption(String message) {
        super(message);
    }
}
