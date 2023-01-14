import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {
  login: FormGroup;

  constructor() {
    this.login =new FormGroup({
      userName: new FormControl('',[Validators.required,Validators.email]),
      password: new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(50)]),
    })
  }

  ngOnInit(): void {
  }
  save(){}

}
