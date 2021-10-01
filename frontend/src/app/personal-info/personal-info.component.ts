import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../user-data.service';
import { User } from '../User/user';
import {InformationPageService} from "../information-page.service";
import {informationPage} from "../InformationPage/informationPage";

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {


  details: any;
  constructor(private userData: UserDataService,private ips: InformationPageService) { }
  ngOnInit(): void {
    this.ips.getInformationPage(this.userData.user.id_user).subscribe( infopage => {
      this.details=infopage;
    });
  }

  user: User = this.userData.user;
}
