import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { LoginService } from '../login.service';
import { UserDataService} from "../user-data.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private router: Router, private acRouter: ActivatedRoute,  private loginService: LoginService,private userData:UserDataService ) { }

  formdata: any;
  return: string = '';

  ngOnInit() {
    this.formdata = new FormGroup({
        email: new FormControl("myemail@domain.com"),
        password: new FormControl("!securePassword!"),
    });

    this.acRouter.queryParams.subscribe((params: any) => this.return = params['return'] || '/profHomepage');
  }



  onClickSubmit(data: any) {
    this.loginService.Login(data.email).subscribe(response => {

      this.loginService.isValid = (data.password == response.password);
      this.router.navigateByUrl(this.return);

      if(this.loginService.isValid){
        console.log("Logged in user with email: " + data.email + " and password: " + data.password);
        this.userData.user=response;
      }else{
        console.log("Incorrect credentials, try again!");
      }
    });
  }

}
