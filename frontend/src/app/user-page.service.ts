import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import {User} from "./User/user";
import {proffessional} from "./Proffessional/proffessional";

@Injectable({
  providedIn: 'root'
})
export class UserPageService {

  fullnames: User[] = new Array<User>();
  private backend_url: String = "http://localhost:8080";

  constructor(private http: HttpClient) { }

   getproff(id : Number){
    return this.http.get<proffessional>(this.backend_url+"/proffessionals/user-"+id,{'headers': httpOptions});
  }

  getuserfromemail(email: String){
    return this.http.get<User>(this.backend_url+"/users/authentication-"+email,{'headers': httpOptions});
  }

  getConnected(id : Number){
    return this.http.get<Array<User>>(this.backend_url+"/connected/full-"+id,{'headers': httpOptions});
  }

}
