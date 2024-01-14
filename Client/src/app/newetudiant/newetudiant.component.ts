import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-newetudiant',
  templateUrl: './newetudiant.component.html',
  styleUrl: './newetudiant.component.css'
})
export class NewetudiantComponent implements  OnInit{
  newetudiantformgroup! : FormGroup;
  private etudiant: any[] = [];
  private errormessage: any;

  constructor(private fb: FormBuilder,private http : HttpClient) {
  }

  ngOnInit(): void {
    this.newetudiantformgroup = this.fb.group({
      id: this.fb.control(null),
      nom: this.fb.control(null),
      prenom: this.fb.control(null),
      adresse: this.fb.control(null),
      codepostale: this.fb.control(null),
      dateNaissance: this.fb.control(null),
      ville: this.fb.control(null),
      sexe: this.fb.control(null),
      numeroTelephone: this.fb.control(null),
      mention: this.fb.control(null),
      promotion: this.fb.group({
        année: [null, Validators.required]
      }),
      tuteur: this.fb.group({
        id: [null, Validators.required]
      }),
      professeur: this.fb.group({
        id: [null, Validators.required]
      })
    });




}
  ajouteretudiant(data : any) {
    //let custumer = this.newetudiantformgroup.value;
    console.log('Données à envoyer :', data);
    this.http.post("http://localhost:8089/etudiants", data).subscribe({
      next: () => {
        alert("Bonne création");

      },
      error: (err) => {
        this.errormessage = err.error.message; // Accessing the error message correctly
      }
    });
  }

  }

