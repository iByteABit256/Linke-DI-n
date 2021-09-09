import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user';
import { proffessional } from './Proffessional/proffessional';

const httpOptions = new HttpHeaders()
  .set('Accept', 'application/json')
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

@Injectable({
  providedIn: 'root'
})
export class GetConnectedService {

  fullnames:[string,string];
  idarr:Number[];
  proffessional : any;
  private backend_url1 = "http://localhost:8080/connected/"
  private backend_url2 = "http://localhost:8080/proffessionals/"
  private backend_url3 = "http://localhost:8080/users/"


  constructor(private http: HttpClient) { }

  getConnected(id : Number){
    console.log("Searching for the connected proffessionals of proffessional with id: " + id);
    this.http.get<Array<Number>>(this.backend_url1+id, {'headers': httpOptions}).subscribe(response => {
      this.idarr=response;
    })
    for(let entry of this.idarr){
      this.http.get<proffessional>(this.backend_url2+entry, {'headers': httpOptions}).subscribe(response => {
        this.proffessional=response;
      })
      this.http.get<User>(this.backend_url3+this.proffessional.id_user, {'headers': httpOptions}).subscribe(response => {
        this.fullnames.push(response.first_name,response.last_name);
      })
    }
  }

}
