import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { User } from '../User/user';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor() { }

  formdata: any;
  user: any;
  response = [];

  ngOnInit() { 
    this.formdata = new FormGroup({ 
        email: new FormControl("myemail@domain.com"),
        password: new FormControl("!securePassword!"),
    }); 
  }

  onClickSubmit(data: any) {
    console.log("Logged in user with email: " + data.email + " and password: " + data.password);
  }

}
