import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { User } from './User/user';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  user: any;
  loggedIn$!: Observable<boolean>;

  constructor() {
    this.setUser(null);
  }

  setUser(user: any){
    this.user = user;
    this.setObservable();
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
