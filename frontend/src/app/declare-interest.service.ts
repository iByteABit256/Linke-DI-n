import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { httpOptions } from './httpOptions';

@Injectable({
  providedIn: 'root'
})
export class DeclareInterestService {
  
  backend_url = "http://localhost:8080/interestdeclarations"

  constructor(private http: HttpClient) { }
  
  declareInterest(id_proffessional: Number, id_post: Number){
    this.http.post(this.backend_url, {id_proffessional, id_post}, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
    });
  }

}