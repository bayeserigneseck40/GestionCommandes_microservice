package com.example.servicedetailcommande.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Produit {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String libelle;
	private int prix;
	private int quantite;
	 
	
	public Produit() {
		super();
	}


	public Produit(Long id, String libelle, int prix, int quantite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


}
