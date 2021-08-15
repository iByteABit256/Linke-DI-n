import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { SignUpService } from '../sign-up.service';
import { User } from '../User/user';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {

  formdata : any;

  constructor(private signUpService: SignUpService) { }

  id: any;
  email: any;
  password: any;
  first_name: any;
  last_name: any;
  phone_number: any;
  profile_picture_dir: any;
  settings: any;

  ngOnInit() { 
    this.formdata = new FormGroup({ 
        id: new FormControl("00100134"),
        email: new FormControl("myemail@domain.com"),
        password: new FormControl("!securePassword!"),
        first_name: new FormControl("John"),
        last_name: new FormControl("Black"),
        phone_number: new FormControl("2130929394"),
        profile_picture_dir: new FormControl("Your pretty face"),
        settings: new FormControl("mysettings.conf")
    }); 
  } 
  onClickSubmit(data: any) {
    this.id = data.id;
    this.email = data.email;
    this.password = data.password;
    this.first_name = data.first_name;
    this.last_name = data.last_name;
    this.phone_number = data.phone_number;
    this.profile_picture_dir = data.profile_picture_dir;
    this.settings = data.settings;
  }

}
