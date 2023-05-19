import { Component, OnInit } from '@angular/core';
import {ApiProduitService} from "../../service/api-produit.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import Produit from '../../model/Produit';

@Component({
  selector: 'app-service-produit',
  templateUrl: './service-produit.component.html',
  styleUrls: ['./service-produit.component.css']
})
export class ServiceProduitComponent implements OnInit {

  categories: any;

  newProduit: Produit = {
    id: 0,
    libelle: '',
    prix: 0,
    quantite: 0
  };
  produitToModify: Produit = {
    id: 0,
    libelle: '',
    prix: 0,
    quantite: 0
  
   
  };
  produits = new Array<Produit>();
  constructor(private apiProduitService: ApiProduitService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
   this. getProduit();
   
  }
  getProduit(){
    this.apiProduitService.getListeProduit().subscribe((results) => {
      console.log(results)
      this.produits = results;
    })

  }

  open(content: any, index?: number) {

    this.modalService.open(content);
    if (index !== undefined) {
      this.produitToModify = this.produits[index]
    }
  }

  initNewProduit() {
    this.newProduit = {
    id: 0,
    libelle: '',
    prix: 0,
    quantite: 0
    };
    this.produitToModify = {
      id: 0,
      libelle: '',
      prix: 0,
      quantite: 0
    };
  }

  enregistrerProduit() {
    try {
      this.apiProduitService.ajoutProduit(this.newProduit).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.produits.push(this.newProduit)
      this.initNewProduit()
      this.getProduit();
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement du produit")
      this.initNewProduit()
    }
  }

  modifierProduit() {
    try {
      this.apiProduitService.modifierProduit(this.produitToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewProduit()
      this.getProduit();
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification du produit")
      this.initNewProduit()
    }
  }

  supprimerProduit(idproduit: number) {
    try {
      let conf=confirm("Etes-vous de supprimer cet element?")
      if (conf){
      this.apiProduitService.supprimerProduit(idproduit).subscribe()
      this.produits = this.produits.filter(pro => pro.id !== idproduit)
      this.getProduit();
      }
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression du produit")
    }
  }

  RechercherProduit(value: { keyword: string; }) {
    try {
      this.apiProduitService.getProduitByLibelle(value.keyword).subscribe((results) => {
        console.log(this.produits);
        this.produits = results;
    })
   } catch (err) {
      console.log(err)
      alert("erreur lors de la recherche de la commande")
      this.initNewProduit()
    }

    
  }



}
