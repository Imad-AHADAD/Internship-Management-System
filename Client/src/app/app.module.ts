import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { EntrepriseComponent } from './entreprise/entreprise.component';
import { StageComponent } from './stage/stage.component';
import { EtudiantComponent } from './etudiant/etudiant.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NewetudiantComponent } from './newetudiant/newetudiant.component';
import { NewstageComponent } from './newstage/newstage.component';
import { NewentrepriseComponent } from './newentreprise/newentreprise.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { provideHttpClient, withFetch } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    EntrepriseComponent,
    StageComponent,
    EtudiantComponent,
    NewetudiantComponent,
    NewstageComponent,
    NewentrepriseComponent,
    LoginComponent,
    AdminComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [
    provideClientHydration(),
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
