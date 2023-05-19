package com.example.servicedetailcommande.model;

import lombok.Data;

@Data
public class DetailCommandePayload {
    private Long idDetail;
    private Long numCommande;
    private int prix;
    private int quantite;
    private String libelle;
    
	public DetailCommandePayload() {
		super();
	}


	public DetailCommandePayload(Long idDetail, Long numCommande, int prix, int quantite, String libelle) {
		super();
		this.idDetail = idDetail;
		this.numCommande = numCommande;
		this.prix = prix;
		this.quantite = quantite;
		this.libelle = libelle;
	}





	public Long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}

	public Long getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
