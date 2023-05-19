package com.example.servicedetailcommande.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicedetailcommande.model.Produit;
import com.example.servicedetailcommande.repository.ProduitRepository;
import com.example.serviceproduit.exception.InvalideProduitException;
import com.example.serviceproduit.exception.ProduitInconnuExecption;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitService {
	
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    RestServiceToGradesApi restServiceToGradesApi;
    
    /**
     * recupération des produits enregistrés dans la bdd
     * @return liste produit enregistrés
     */
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }
    /**
     * Recuperation d'un Produit par son ID 
     * @return produit si trouvé, sinon null
     */
    public Optional<Produit> getProduitById(Long idproduit) {
        return produitRepository.findById(idproduit);
    }
    
    public Optional<Produit> getProduitByLibelle(String libelle) {
        return produitRepository.findByLibelle(libelle);
    }
	
    /**
     * Ajout d'un produit
     * @param produit produit à ajouter
     * @throws InvalideProduitException
     */
    public void ajouterNouveauProduit(Produit produit) throws InvalideProduitException {
 
            produitRepository.save(produit);
       
    }


    /**
     * Modification d'un produit
     * @param produit produit à modifier
     */
    public void updateProduit(Produit produit) throws ProduitInconnuExecption {
        if (!produitRepository.existsById(produit.getId())) {
            throw new ProduitInconnuExecption("Cet produit n'existe pas dans la base de données");
        }
        produitRepository.save(produit);
    }


    /**
     * Suppression d'un produit par son identifiant 
     * @param id id produit
     * @throws produitInconnuExecption
     */
    public void supprimerProduit(Long id) throws ProduitInconnuExecption {
        if (!produitRepository.existsById(id)) {
            throw new ProduitInconnuExecption("Cet produit n'existe pas dans la base de données");
        }
        produitRepository.deleteById(id);
    }

}
