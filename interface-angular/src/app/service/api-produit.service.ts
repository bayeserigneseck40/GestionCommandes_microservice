import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import Produit from '../model/Produit';

@Injectable({
  providedIn: 'root'
})
export class ApiProduitService {
  private static urlProduitApi = "http://localhost:8083/produit"
  constructor(private http: HttpClient) { }

  /**
   * Recuperation de la liste des produits
   */
  public getListeProduit() {
    return this.http.get(`${ApiProduitService.urlProduitApi}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout produit
   * @paramproduit
   */
  public ajoutProduit(produit: Produit) {
    return this.http.post(`${ApiProduitService.urlProduitApi}`, produit).pipe(catchError(this.handleError))
  }


  /**
   * modification produit
   * @param produit
   */
  public modifierProduit(produit: Produit) {
    return this.http.put(`${ApiProduitService.urlProduitApi}`, produit).pipe(catchError(this.handleError))
  }

  /**
   * suppression produit
   * @param idproduit
   */
  public supprimerProduit(idproduit: number) {
    return this.http.delete(`${ApiProduitService.urlProduitApi}/${idproduit}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }

  getProduitByLibelle(libelle: string) {
    return this.http.get(`${ApiProduitService.urlProduitApi}/${libelle}`).pipe(catchError(this.handleError))
  }


}
