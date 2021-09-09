import { Component, OnInit } from '@angular/core';
import {GetConnectedService} from "../get-connected.service";
import {UserDataService} from "../user-data.service";

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})
export class NetworkComponent implements OnInit {

  fullnames:[string,string];
  constructor(private uds: UserDataService,private gc : GetConnectedService) { }

  ngOnInit(): void {
    this.gc.getConnected(this.uds.user.id_user);
    this.fullnames=this.gc.fullnames;

  }

}
