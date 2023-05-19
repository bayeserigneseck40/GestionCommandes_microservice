package com.example.serviceproduit.exception;

/**
 * Exception lancée si on essaie une modification sur un produit qui n'existe pas
 */
public class ProduitInconnuExecption extends Exception{
    public ProduitInconnuExecption(String message) {
        super(message);
    }
}
