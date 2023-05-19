import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, ObservableInput} from "rxjs";
import Client from '../model/Client';

@Injectable({
  providedIn: 'root'
})
export class ApiClientService {
  private static urlClientApi = "http://localhost:8081/client"
  constructor(private http: HttpClient) { }

  /**
   * Recuperation de la liste des clients
   */
  public getListeClient() {
    return this.http.get(`${ApiClientService.urlClientApi}/all`).pipe(catchError(this.handleError))
  }

  /**
   * ajout client
   * @param client
   */
  public ajoutClient(client: Client) {
    return this.http.post(`${ApiClientService.urlClientApi}`, client).pipe(catchError(this.handleError))
  }


  /**
   * modification client
   * @param client
   */
  public modifierClient(client: Client) {
    return this.http.put(`${ApiClientService.urlClientApi}`, client).pipe(catchError(this.handleError))
  }

  /**
   * suppression client
   * @param idclient
   */
  public supprimerClient(idclient: number) {
    return this.http.delete(`${ApiClientService.urlClientApi}/${idclient}`).pipe(catchError(this.handleError))
  }

  handleError(error: any, caught: Observable<any>) : ObservableInput<any>{
    throw new Error(error)
  }


}
