import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { Post } from '../Post/post';
import { PostService } from '../post.service';
import { formatDate } from '@angular/common';
import { UserDataService } from '../user-data.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  formdata: any;
  post: any;

  constructor(private postService: PostService, private userData: UserDataService) { }

  ngOnInit(): void {
    this.formdata = new FormGroup({ 
      title: new FormControl(""),
      body: new FormControl(""),
    }); 
  }

  onClickSubmit(data: any) {
    this.post = new Post(this.userData.proffessional.id_proffessional, data.title, data.body, formatDate(new Date(), "YYYY-MM-dd hh:mm:ss", "en-US"));
    console.log("Created post: " + this.post);
    this.postService.createPost(this.post).subscribe(data => {
      console.log(data);
    })
  }
}
