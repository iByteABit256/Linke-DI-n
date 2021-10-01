import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { httpOptions } from './httpOptions';
import { Post } from './Post/post';
import { UserDataService } from './user-data.service';

@Injectable({
  providedIn: 'root'
})
export class RecommendedPostsService {
  private backend_url = "http://localhost:8080/posts/recommendations-"
  private loggedIn: boolean = false;
  posts!: Post[];

  constructor(private http: HttpClient, private userData: UserDataService) { }

  async getRecommendedPosts(){
    console.log("Getting recommended posts");

    await this.http.get<Post[]>(this.backend_url+this.userData.proffessional.id_proffessional, {'headers': httpOptions})
    .toPromise()
    .then(data => {
      this.posts = data;
    });

    return this.posts;
  }
}
