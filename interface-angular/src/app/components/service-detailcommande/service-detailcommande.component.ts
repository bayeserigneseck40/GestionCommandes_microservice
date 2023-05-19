import { Component, OnInit } from '@angular/core';
import {ApiDetailCommandeService} from "../../service/api-detailcommande.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import DetailCommande from '../../model/DetailCommande';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import Produit from 'src/app/model/Produit';
import { ApiProduitService } from 'src/app/service/api-produit.service';

@Component({
  selector: 'app-service-detailcommande',
  templateUrl: './service-detailcommande.component.html',
  styleUrls: ['./service-detailcommande.component.css']
})
export class ServiceDetailCommandeComponent implements OnInit {
  newDetailCommande: DetailCommande = {
    idDetail: 0,
    libelle: '',
    prix: 0,
    quantite: 0,
    numCommande:0,
    montant:0
  };
  detailcommandeToModify: DetailCommande = {
    idDetail: 0,
    libelle: '',
    prix: 0,
    quantite: 0,
    numCommande:0,
    montant:0
  };
  produits = new Array<Produit>();
  detailcommandes = new Array<DetailCommande>();
  constructor(private apiDetailCommandeService: ApiDetailCommandeService,private apiProduitService: ApiProduitService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getDetails();
  }
  getDetails(){
    this.apiDetailCommandeService.getListeDetailCommande().subscribe((results) => {
      console.log(results)
      this.detailcommandes = results;
    })
    this.apiProduitService.getListeProduit().subscribe((results) => {
      console.log(results)
      this.produits = results;
    })
  }


 

  open(content: any, index?: number) {
    this.modalService.open(content);
    if (index !== undefined) {
      this.detailcommandeToModify = this.detailcommandes[index]
    }
  }

  initNewDetailCommande() {
    this.newDetailCommande = {
      idDetail: 0,
      libelle: '',
      prix: 0,
      quantite: 0,
      numCommande:0,
      montant:0
    };
    this.detailcommandeToModify = {
      idDetail: 0,
    libelle: '',
    prix: 0,
    quantite: 0,
    numCommande:0,
    montant:0
    };
  }

  enregistrerDetailCommande() {
    try {
      this.apiDetailCommandeService.ajoutDetailCommande(this.newDetailCommande).subscribe();
      const exitButton = document.getElementById("close-btn")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.detailcommandes.push(this.newDetailCommande)
      this.initNewDetailCommande()
      this.getDetails();
    } catch (err) {
      console.log(err)
      alert("erreur lors de l'enregistrement du produit")
      this.initNewDetailCommande()
    }
  }

  modifierDetailCommande() {
    try {
      this.apiDetailCommandeService.modifierDetailCommande(this.detailcommandeToModify).subscribe();
      const exitButton = document.getElementById("close-btn-modify")
      if (exitButton != undefined){
        exitButton.click()
      }
      this.initNewDetailCommande()
      this.getDetails();
    } catch (err) {
      console.log(err)
      alert("erreur lors de la modification du produit")
      this.initNewDetailCommande()
    }
  }

  supprimerDetailCommande(idDetail: number) {
    try {
      let conf=confirm("Etes-vous de supprimer cet element?")
      if (conf){
      this.apiDetailCommandeService.supprimerDetailCommande(idDetail).subscribe()
      this.detailcommandes = this.detailcommandes.filter(detail => detail.idDetail !== idDetail)
      this.getDetails();
    }
    } catch (err) {
      console.log(err)
      alert("erreur lors de la suppression du produit")
    }
  }

}
