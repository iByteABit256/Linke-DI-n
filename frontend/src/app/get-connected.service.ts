import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user';
import { proffessional } from './Proffessional/proffessional';
import { httpOptions } from './httpOptions';

@Injectable({
  providedIn: 'root'
})
export class GetConnectedService {

  fullnames: User[] = new Array<User>();
  idarr!:Number[];
  proffessional : any;
  private backend_url = "https://localhost:8080/"

  constructor(private http: HttpClient) { }

  async getConnected(id : Number){
    console.log("Searching for the connected proffessionals of proffessional with id: " + id);
    await this.http.get<Array<Number>>(this.backend_url+"connected/"+id, {'headers': httpOptions})
      .toPromise()
      .then(response => {
        this.idarr=response;
      })
    for(let entry of this.idarr){
      await this.http.get<proffessional>(this.backend_url+"proffessionals/"+entry, {'headers': httpOptions})
        .toPromise()
        .then(response => {
          this.proffessional=response;
        })
      await this.http.get<User>(this.backend_url+"users/"+this.proffessional.id_user, {'headers': httpOptions})
        .toPromise()
        .then(response => {
          this.fullnames.push(response);
        })
    }
  }

  getUsers(id: Number): User[]{
    if(this.fullnames.length == 0){
      this.getConnected(id);
    }

    return this.fullnames;
  }
}
