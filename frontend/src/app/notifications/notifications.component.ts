import { Component, OnInit } from '@angular/core';
import {ConnectionRequestService} from "../connection-request.service";
import {UserDataService} from "../user-data.service";
import {ConnectionRequest} from "../ConnectionRequest/connectionrequest";
import {User} from "../User/user";
import {proffessional} from "../Proffessional/proffessional";

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  user:any;
  proffessionalswhorequested: User[]= new Array<User>();
  pendingrequests: ConnectionRequest[]= new Array<ConnectionRequest>();
  constructor(private crs:ConnectionRequestService,private uds:UserDataService) { }


  ngOnInit(): void {
    this.crs.getconnectionrequests(this.uds.proffessional.id_proffessional).subscribe(cr=>{
      this.pendingrequests=cr;
      this.getproffessionals();
    })

  }

  onClickAcceptConnectionRequest(cr:ConnectionRequest){
    this.crs.acceptconnectionrequest(cr.id_proffessional1,cr.id_proffessional2);
    this.ngOnInit();
  }

  onClickRejectConnectionRequest(cr:ConnectionRequest){
    this.crs.rejectconnectionrequest(cr.id_proffessional1,cr.id_proffessional2);
    this.ngOnInit();
  }

  getproffessionals(){
    for(let i = 0; i < this.pendingrequests.length; i++){
      this.uds.getUserFromProf(this.pendingrequests[i].id_proffessional1).subscribe(user =>{
        this.user=user;
        this.proffessionalswhorequested.push(this.user);
      })
    }
  }

}
