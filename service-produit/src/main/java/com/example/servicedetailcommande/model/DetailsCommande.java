package com.example.servicedetailcommande.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor()
@NoArgsConstructor
public class DetailsCommande {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetail;
    private String libelle;
    private int prix;
    private int quantite;
    private int montant;
    private Long numCommande ;
    
	public DetailsCommande() {
		super();
	}
	public DetailsCommande(Long idDetail, String libelle, int prix, int qte, int montant, Long numCommande) {
		super();
		this.idDetail = idDetail;
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = qte;
		this.montant = montant;
		this.numCommande = numCommande;
	}



	public Long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
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

	public void setQuantite(int qte) {
		this.quantite = qte;
	}

	public Long getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getMontant() {
		return montant;
	}



	public void setMontant(int montant) {
		this.montant = montant;
	}

	
}
