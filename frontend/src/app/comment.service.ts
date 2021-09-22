import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { httpOptions } from './httpOptions';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  
  backend_url = "http://localhost:8080/comments"

  constructor(private http: HttpClient) { }
  
  postComment(id_proffessional: Number, id_post: Number, body: String){
    this.http.post(this.backend_url, {id_proffessional, id_post, body}, {'headers': httpOptions}).subscribe(data => {
      console.log(data);
    });
  }

}
