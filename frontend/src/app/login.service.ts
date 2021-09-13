import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user'
import { httpOptions } from './httpOptions';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private backend_url = "http://localhost:8080/users/authentication-"
  isValid = false;

  constructor(private http: HttpClient) { }
  Login(email: String){
    console.log("Searching user with email: " + email);
    return this.http.get<User>(this.backend_url+email, {'headers': httpOptions});
  }
}
