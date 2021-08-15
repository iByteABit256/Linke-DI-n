import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from './User/user'

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private backend_url = "https://localhost:8080/users"
  constructor(private http: HttpClient) { }
  SignUp(user: User){
    this.http.post(this.backend_url, user);
  }
}
