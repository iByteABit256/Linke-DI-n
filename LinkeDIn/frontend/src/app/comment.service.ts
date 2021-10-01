import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { httpOptions } from './httpOptions';
import { Comment } from './Comment/comment';
import {User} from "./User/user";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  backend_url = "http://localhost:8080/comments"
  comments!: Comment[];

  constructor(private http: HttpClient) { }

  async postComment(id_proffessional: Number, id_post: Number, body: String){
    await this.http.post(this.backend_url, {id_proffessional, id_post, body}, {'headers': httpOptions})
    .toPromise()
    .then(data => {
      console.log(data);
    });
  }

  getPostComments(id_post: Number){
    console.log("hiiiiii");
    return this.http.get<Comment[]>(this.backend_url+"/"+id_post, {'headers': httpOptions});
  }

  getUsersFromComments(id_post:Number){
    return this.http.get<Array<User>>(this.backend_url+"/users-"+id_post, {'headers': httpOptions});
  }

}
