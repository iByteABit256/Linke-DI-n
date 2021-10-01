import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user';
import { proffessional } from './Proffessional/proffessional';
import { httpOptions } from './httpOptions';

@Injectable({
  providedIn: 'root'
})
export class GetConnectedService {

  idarr!:Number[];
  proffessional : any;
  private backend_url = "http://localhost:8080/connected/"

  constructor(private http: HttpClient) { }

  getConnected(id : Number){
    return this.http.get<User[]>(this.backend_url+"full-"+id, {'headers': httpOptions});
  }

}
