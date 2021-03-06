import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { httpOptions } from './httpOptions';
import { Post } from './Post/post';
import { UserDataService } from './user-data.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private backend_url = "http://localhost:8080/posts"
  private loggedIn: boolean = false;
  posts!: Post[];

  constructor(private http: HttpClient, private userData: UserDataService) { }

  createPost(post: Post){
    console.log("Posting: " + post);
    return this.http.post<Post>(this.backend_url, post, {'headers': httpOptions});
  }

  async getPosts(): Promise<Post[]>{
    console.log("Getting posts");

    await this.http.get<Post[]>(this.backend_url+"/fullproffessional-"+this.userData.proffessional.id_proffessional, {'headers': httpOptions})
    .toPromise()
    .then(data => {
      this.posts = data;
    });
    return this.posts;


  }

  getUserPosts(){
    return this.http.get<Array<Post>>(this.backend_url+"/proffessional-"+this.userData.proffessional.id_proffessional, {'headers': httpOptions});
  }

}
