package com.example.servicedetailcommande.controller;

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
import com.example.servicedetailcommande.model.Produit;
import com.example.servicedetailcommande.service.DetailsService;
import com.example.servicedetailcommande.service.ProduitService;
import com.example.serviceproduit.exception.InvalideProduitException;
import com.example.serviceproduit.exception.ProduitInconnuExecption;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitController {
	
	  @Autowired
	    private ProduitService produitservice;
	 /**
     * Recuperation de la liste des produits
     * @return Liste des produits
     */
    @GetMapping("/all")
    public ResponseEntity<List<Produit>> getAllProduit() {
        return ResponseEntity.ok( produitservice.getAllProduit());
    }
    /**
     * recuperation produit par son ID
     * @param id
     * @return
     */
    @GetMapping("/{idproduit}")
    public ResponseEntity<Optional<Produit>> getProduitById(
            @PathVariable("idproduit") Long id) {
        return ResponseEntity.ok(produitservice.getProduitById(id));
    }
    
    
    @GetMapping("/{libelle}")
    public ResponseEntity<Optional<Produit>> getProduitByLib(
            @PathVariable("libelle") String libelle) {
        return ResponseEntity.ok(produitservice.getProduitByLibelle(libelle));
    }
    
    /**
     * Ajout d'un nouveau produit
     * @param client
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws InvalideProduitException
     */
    @PostMapping
    public ResponseEntity ajouterProduit(
            @RequestBody  Produit produit) throws InvalideProduitException {
    	produitservice.ajouterNouveauProduit(produit);
        return ResponseEntity.ok().build();
    }

    /**
     * modification d'un produit
     * @param produit
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws ProduitInconnuExecption
     */
    @PutMapping
    public ResponseEntity modifierProduit(
            @RequestBody  Produit produit) throws ProduitInconnuExecption {
    	produitservice.updateProduit(produit);
        return ResponseEntity.ok().build();
    }
    /**
     * suppression d'un produit
     * @param id
     * @return reponse vide avec un statut 200 pour indiquer que tout s'est bien passé
     * @throws ClientInconnuExecption
     */
    @DeleteMapping("/{idproduit}")
    public ResponseEntity supprimerProduit(
            @PathVariable("idproduit") Long id
    ) throws ProduitInconnuExecption {
    	produitservice.supprimerProduit(id);
        return ResponseEntity.ok().build();
    }


}
