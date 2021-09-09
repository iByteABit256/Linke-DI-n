import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user';
import { httpOptions } from './httpOptions';
import { proffessional } from './Proffessional/proffessional';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  user: any;
  loggedIn$!: Observable<boolean>;
  proffessional: proffessional;
  backend_url: String = "http://localhost:8080/";

  constructor(private http: HttpClient) {
    this.proffessional = new proffessional(0, 0);
    this.setUser(null);
  }

  setUser(user: any){
    this.user = user;
    this.setObservable();
    
    if(user != null){
      this.http.get<proffessional>(this.backend_url+"proffessionals/user-"+user.id_user, {'headers': httpOptions})
        .subscribe(proff => {
          this.proffessional.set(proff.id_proffessional, proff.id_user, proff.id_information_page);
        });
    }
  }

  setObservable(){
    this.loggedIn$ = Observable.create((obs: Observer<boolean>) => {
      setInterval(
        () => {
          obs.next((this.user != null));
        }, 1000);
    });
  }
}
