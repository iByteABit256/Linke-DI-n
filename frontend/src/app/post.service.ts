import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './User/user';
import { httpOptions } from './httpOptions';
import { Post } from './Post/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private backend_url = "http://localhost:8080/posts"

  constructor(private http: HttpClient) { }
  createPost(post: Post){
    console.log("Posting: " + post);
    return this.http.post<User>(this.backend_url, post, {'headers': httpOptions});
  }
}
