import { Component, OnInit } from '@angular/core';
import { GetConnectedService } from "../get-connected.service";
import { UserDataService } from "../user-data.service";
import { User } from '../User/user';
import {FormControl, FormGroup} from "@angular/forms";
import {SearchNameService} from "../search-name.service";
import {proffessional} from "../Proffessional/proffessional";

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})

export class NetworkComponent implements OnInit {


  searchresults: User[]= new Array<User>();
  formdata: any;
  fullnames:User[] = new Array<User>();
  constructor(private uds: UserDataService, private gc : GetConnectedService, private sn: SearchNameService) { }

  ngOnInit(): void {
    this.formdata = new FormGroup({
      searchname: new FormControl("Search by typing a first name or a last name!!"),
    });

    this.fullnames = this.gc.getUsers(this.uds.proffessional.id_proffessional);
  }

  onClickSearch(data:any){

    this.sn.searchName(data.searchname).subscribe( names => {
      this.searchresults = names;
    })

  }
}
