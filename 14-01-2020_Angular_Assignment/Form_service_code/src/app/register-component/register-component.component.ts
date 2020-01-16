import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormControlName, Validators, EmailValidator } from '@angular/forms';
import { DataServiceService } from '../providers/data-service.service';

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {

  constructor(private dataservice:DataServiceService) { }
  
  ngOnInit() {

  }
  Id:number;
  fname:string;
  Email:string;
  RegisterForm = new FormGroup({
    id:new FormControl('',Validators.required),
    firstname: new FormControl('',Validators.required),
    email:new FormControl('',Validators.required)
  });

  onSubmit() {
    this.dataservice.putdata(this.RegisterForm.get('id').value,this.RegisterForm.get('firstname').value,this.RegisterForm.get('email').value);
    console.log(this.RegisterForm.get('id').value);
    this.Id=0;
    this.Email='';
    this.fname='';
  }
}
