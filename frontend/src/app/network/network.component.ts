import { Component, OnInit } from '@angular/core';
import { GetConnectedService } from "../get-connected.service";
import { UserDataService } from "../user-data.service";
import { User } from '../User/user';

@Component({
  selector: 'app-network',
  templateUrl: './network.component.html',
  styleUrls: ['./network.component.css']
})

export class NetworkComponent implements OnInit {

  fullnames:User[] = new Array<User>();
  constructor(private uds: UserDataService, private gc : GetConnectedService) { }

  ngOnInit(): void {
    this.fullnames = this.gc.getUsers(this.uds.proffessional.id_proffessional);
  }
}
