import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import { Location } from '@angular/common';
@Component({
  selector: 'app-stage',
  templateUrl: './stage.component.html',
  styleUrl: './stage.component.css'
})
export class StageComponent implements  OnInit{
  stages : any[] = [];
  errormessage! : String ;
  formgroup! : FormGroup;
  stage: any;
  constructor(private http:HttpClient,private fb : FormBuilder,public router: Router,private routr: ActivatedRoute,private location: Location) {
  }
  ngOnInit(): void {
    this.formgroup=this.fb.group({
      keyword: this.fb.control("")
    })
    this.http.get("http://localhost:8089/stages").subscribe({
      next : (data)=>{
        if (Array.isArray(data)){
          this.stages=data;
        }

      },
      error : (err)=>{
        this.errormessage=err.message;
      }
    });
  }
  handleSearchStage() {
    let kw=this.formgroup.value.keyword;
    let id= +kw;
    this.http.get("http://localhost:8089/etudiants/stageetudiants"+id).subscribe({
      next : (data)=>{
        if (Array.isArray(data)) {
          this.stages = data;
        }
      },
      error : (err)=>{
        this.errormessage=err.message;
      }
    });
  }

  Stagedelete(c: any) {
    let conf = confirm("Are you sure");
    if(!conf) return;
    this.http.delete("http://localhost:8089/stages/" + c.id).subscribe({
      next: () => {
        window.location.reload();
        }
      ,
      error: (err) => {
        this.errormessage = err.message;
      }
    });
  }

  navigatetonewroute() {
    this.router.navigate(['/newetudiant']);
  }
}
