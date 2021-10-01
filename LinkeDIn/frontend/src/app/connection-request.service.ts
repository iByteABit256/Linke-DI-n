import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {ConnectionRequest} from "./ConnectionRequest/connectionrequest";
import { httpOptions } from './httpOptions';
import {Comment} from "./Comment/comment";


@Injectable({
  providedIn: 'root'
})



export class ConnectionRequestService {
  private backend_url = "http://localhost:8080/connectionrequests"
  constructor(private http: HttpClient) { }

  createconnectionrequest(connectionrequest:ConnectionRequest){
    console.log("Creating connection request: " + connectionrequest);
    return this.http.post<ConnectionRequest>(this.backend_url,connectionrequest, {'headers': httpOptions});
  }

  acceptconnectionrequest(id_proffessionalsender:Number,id_proffessionalreceiver:Number){
    console.log("Proffessional with id "+ id_proffessionalreceiver +" accepted connection request from proffessional with id "+ id_proffessionalsender);
    return this.http.get(this.backend_url+"/accept/"+id_proffessionalreceiver + "/"+ id_proffessionalsender, {'headers': httpOptions});

  }

  rejectconnectionrequest(id_proffessionalsender:Number,id_proffessionalreceiver:Number) {
    console.log("Proffessional with id " + id_proffessionalreceiver + " rejected connection request from proffessional with id " + id_proffessionalsender);
    return this.http.get(this.backend_url + "/reject/" + id_proffessionalreceiver + "/" + id_proffessionalsender, {'headers': httpOptions});
  }

  getconnectionrequests(id:Number){
    console.log("Getting connection requests of proffessional with id " + id);
    return this.http.get<Array<ConnectionRequest>>(this.backend_url+"/"+id, {'headers': httpOptions});
  }



}
