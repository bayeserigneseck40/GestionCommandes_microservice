package com.example.servicedetailcommande.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicedetailcommande.model.DetailsCommande;
import com.example.servicedetailcommande.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	Optional<Produit> findByLibelle(String libelle);

}
