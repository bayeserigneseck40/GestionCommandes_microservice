package com.example.servicecommande.controller;

import com.example.servicecommande.exception.CommandeInconnuException;
import com.example.servicecommande.model.Commande;
import com.example.servicecommande.model.CommandePayload;
import com.example.servicecommande.service.CommandeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest controller pour exposer le service de gestion des commandes
 */
@RestController
@RequestMapping("commande")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;


    /**
     * Recuperation liste des clients
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommande() {
        return ResponseEntity.ok(commandeService.getAll());
    }

    /**
     * Recuperation commande avec Id client
     * @param idClient
     * @return
     */
    /** 
    @GetMapping("/{nomClient}")
    public ResponseEntity getCommandeById(
            @PathVariable("{nomClient") String nomClient
    ) {
        return ResponseEntity.ok(commandeService.getCommandeByNomClient(nomClient));
    }     
       */
    /**
     * Recuperation commande avec Id commande
     * @param numcommande
     * @return
     */
     @GetMapping("/{numCommande}")
    public ResponseEntity getCommandeByNumCommande(
            @PathVariable("numCommande") Long numCommande
    ) {
        return ResponseEntity.ok(commandeService.getCommandeByNumCommande(numCommande));
    }
     


    /**
     * ajouter Commande client
     * @param payload
     * @return
     * @throws Exception
     */
    @PostMapping
    public ResponseEntity ajouterCommandeClient(
            @RequestBody CommandePayload payload
    ) throws Exception {
        commandeService.ajoutCommande(payload);
        return ResponseEntity.ok().build();
    }

    /**
     * modifier commande client
     * @param payload
     * @return
     * @throws Exception
     */
    @PutMapping
    public ResponseEntity modifierCommandeClient(
            @RequestBody CommandePayload payload
    ) throws Exception {
        commandeService.updateCommande(payload);
        return ResponseEntity.ok().build();
    }

    /**
     * suppresssion d'une commande d'un client à partir de son ID
     * @param idClient ID
     * @return response vide avec un statut OK (code 200) si tout s'est bien passé
     * @throws CommandeInconnuException
     */
    @DeleteMapping("/{idClient}")
    public ResponseEntity supprimerMoyenne(
            @PathVariable("idClient") Long idclient
    ) throws CommandeInconnuException {
        commandeService.supprimerCommande(idclient);
        return ResponseEntity.ok().build();
    }


}
