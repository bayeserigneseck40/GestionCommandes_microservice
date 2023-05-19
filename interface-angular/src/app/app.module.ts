import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {HttpClientModule} from "@angular/common/http";
import { ServiceClientComponent } from './components/service-client/service-client.component';
import { ServiceCommandeComponent } from './components/service-commande/service-commande.component';
import { ServiceProduitComponent } from './components/service-produit/service-produit.component';
import { ServiceDetailCommandeComponent } from './components/service-detailcommande/service-detailcommande.component';
import {FormsModule,ReactiveFormsModule } from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    ServiceClientComponent,
    ServiceCommandeComponent,
    ServiceProduitComponent,
    ServiceDetailCommandeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
