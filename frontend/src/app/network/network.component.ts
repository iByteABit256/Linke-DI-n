import { Component, OnInit } from '@angular/core';
import { GetConnectedService } from "../get-connected.service";
import { UserDataService } from "../user-data.service";
import { User } from '../User/user';
import {FormControl, FormGroup} from "@angular/forms";
import {SearchNameService} from "../search-name.service";
import {proffessional} from "../Proffessional/proffessional";
import {ConnectionRequest} from "../ConnectionRequest/connectionrequest";
import {ConnectionRequestService} from "../connection-request.service";

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})

export class NetworkComponent implements OnInit {

  proffessional:any;
  connectionrequest: any;
  searchresults: User[]= new Array<User>();
  formdata: any;
  fullnames:User[] = new Array<User>();
  constructor(private uds: UserDataService, private gc : GetConnectedService, private sn: SearchNameService,private crs: ConnectionRequestService) { }

  ngOnInit(): void {
    this.formdata = new FormGroup({
      searchname: new FormControl(""),
    });

    this.fullnames = this.gc.getUsers(this.uds.proffessional.id_proffessional);
  }

  onClickSearch(data:any){

    this.sn.searchName(data.searchname).subscribe( names => {
      this.searchresults = names;
    })

  }

  sendConnectionRequest(user:User){
    this.uds.getproffessionalbyuserid(user.id_user).subscribe(proff =>{
      this.proffessional=proff;
      this.connectionrequest=new ConnectionRequest(this.uds.proffessional.id_proffessional,this.proffessional.id_proffessional);
      this.crs.createconnectionrequest(this.connectionrequest).subscribe(cr =>{
        console.log("Proffessional with id "+ this.uds.proffessional.id_proffessional + " just requested a connection with proffessional with id " + this.proffessional.id_proffessional);
      })
    })

  }
}
