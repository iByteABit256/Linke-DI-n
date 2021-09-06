import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from './User/user'
import { informationPage } from './InformationPage/informationPage';
import { proffessional } from './Proffessional/proffessional';

const httpOptions = new HttpHeaders()
  .set('Accept', 'application/json')
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private backend_url = "http://localhost:8080/"
  proff: proffessional = new proffessional(-1, -1);

  constructor(private http: HttpClient) { }
  async SignUp(user: User){
    console.log("Signing up user with email: " + user.email);

    await this.http.post<User>(this.backend_url+"users", user, {'headers': httpOptions})
    .toPromise()
    .then(response => {
      this.proff.id_user = response.id_user;
    });

    await this.http.post<informationPage>(this.backend_url+"informationpages", new informationPage("", ""), {'headers': httpOptions})
    .toPromise()
    .then(response => {
      this.proff.id_information_page = response.id_information_page;
    });

    this.http.post<proffessional>(this.backend_url+"proffessionals", this.proff, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
    });
  }
}
