import { Component, OnInit } from '@angular/core';
import {GetConnectedService} from "../get-connected.service";
import {UserDataService} from "../user-data.service";
import { Subscription} from "rxjs";
import { Router, ActivatedRoute, Params } from '@angular/router';
import {User} from "../User/user";
import {proffessional} from "../Proffessional/proffessional";
import {UserPageService} from "../user-page.service";

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  user:any;
  proff: any;
  connected: User[] = new Array<User>();
  email: any;
  sub: any;

  constructor(private uds:UserDataService,private ups: UserPageService, private route: ActivatedRoute) { }
  //TO DO CREATE USERPAGE SERVICE THAT GETS ALL THE DATA ONNTHE USERWITH THE EMAIL GIVEN AT PARAMS
  ngOnInit(): void {
    this.sub = this.route.queryParams.subscribe((params: Params) => {
      this.email = params['email'];
    });
    console.log(this.email);

    this.ups.getuserfromemail(this.email).subscribe(user => {
      this.user = user;
      //console.log(user);
    })

    this.ups.getproff(this.user.id_user).subscribe(proff => {
      this.proff = proff;
    })
    this.ups.getConnected(this.proff.id_proffessional).subscribe(connected => {
      this.connected = connected;
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
