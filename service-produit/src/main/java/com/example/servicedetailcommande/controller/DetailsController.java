package com.example.servicedetailcommande.controller;


import com.example.servicedetailcommande.model.DetailCommandePayload;
import com.example.servicedetailcommande.model.DetailsCommande;
import com.example.servicedetailcommande.model.Produit;
import com.example.servicedetailcommande.service.DetailsService;
import com.example.serviceproduit.exception.CommandeInconnuException;
import com.example.serviceproduit.exception.InvalideProduitException;
import com.example.serviceproduit.exception.ProduitInconnuExecption;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Details")
@CrossOrigin("*")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;
    
    
	 /**
     * Recuperation de la liste des details commande
     * @return Liste des details
     */
    @GetMapping("/all")
    public ResponseEntity<List<DetailsCommande>> getAllDetails() {
        return ResponseEntity.ok( detailsService.getAllDetails());
    }
    /**
     * recuperation detail par son ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<DetailsCommande> getDetailById(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(detailsService.getDetailsCommandeById(id));
    }
    
    /**
     * Ajout d'un nouveau details commande
     * @param commande
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws Exception 
     */
    @PostMapping
    public ResponseEntity ajouterDetailsCommande(
            @RequestBody  DetailCommandePayload details) throws Exception {
    	detailsService.ajoutDetailCommande(details);
        return ResponseEntity.ok().build();
    }


    /**
     * modification des details
     * @param commande
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws Exception 
     */
    @PutMapping
    public ResponseEntity modifierDetailsCommande(
            @RequestBody  DetailCommandePayload  details) throws Exception {
    	detailsService.updateCommande(details);
        return ResponseEntity.ok().build();
    }


    /**
     * suppression des details
     * @param id
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws CommandeInconnuException 
     * @throws ClientInconnuExecption
     */
    @DeleteMapping("/{idDetails}")
    public ResponseEntity supprimerDetailsCommande(
            @PathVariable("idDetails") Long id
    ) throws ProduitInconnuExecption, CommandeInconnuException {
    	detailsService.supprimerDetailCommande(id);
        return ResponseEntity.ok().build();
    
    }
}