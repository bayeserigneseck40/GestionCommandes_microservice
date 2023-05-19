package com.example.serviceclient.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Data
@Entity
public class Client {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String numero;
    
    
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long id, String prenom, String nom, String numero) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numero = numero;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
    
    
}
