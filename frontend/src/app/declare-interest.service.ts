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
    return this.http.post(this.backend_url, {id_proffessional, id_post}, {'headers': httpOptions});
  }
  
  getLikes(id_post: Number){
    return this.http.get<Number>(this.backend_url+"/post-"+id_post, {'headers': httpOptions});
  }

}
