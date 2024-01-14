import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ServiceloginService} from "../servicelogin.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  form! : FormGroup;
  erromessage!: String;
  constructor(private fb:FormBuilder, public service:ServiceloginService,private router:Router) {
  }
  ngOnInit(): void {
    this.form=this.fb.group({
      username: this.fb.control(""),
      password: this.fb.control("")
    })
  }

  entre() {
     let username = this.form.value.username;
     let password = this.form.value.password;

     this.service.login(username,password).subscribe({
       next:(data)=>{
         this.service.autentifieruser(data).subscribe({
           next:(dataa)=>{
             this.router.navigateByUrl("/admin");
           },
           error: (err)=>{
             this.erromessage=err.message;
           }
         })
       },
       error: (err)=>{
         this.erromessage=err.message;
       }
       }
     )
  }
}

 /* reloadPage(): void {
    window.location.reload();
  }*/

