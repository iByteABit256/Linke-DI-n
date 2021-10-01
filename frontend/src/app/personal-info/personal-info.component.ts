import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../user-data.service';
import { User } from '../User/user';
import {InformationPageService} from "../information-page.service";
import {informationPage} from "../InformationPage/informationPage";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {

  biodata:any;
  workexp:any;
  details: any;
  constructor(private userData: UserDataService,private ips: InformationPageService) { }
  ngOnInit(): void {
    this.ips.getInformationPage(this.userData.user.id_user).subscribe( infopage => {
      this.details=infopage;
    });

    this.biodata = new FormGroup({
      body: new FormControl(""),
    });

    this.workexp = new FormGroup({
      body: new FormControl(""),
    });

  }

  user: User = this.userData.user;


  onClickChangeBio(data:any){
    this.ips.changeBio(this.details,data.body).subscribe(info =>{
      console.log(info);
      this.ngOnInit();
    });
  }

  onClickChangeWorkExp(data:any){
    this.ips.changeWorkExp(this.details,data.body).subscribe(info =>{
      console.log(info);
      this.ngOnInit();
    });

  }

}
