import { Component, OnInit } from '@angular/core';
import {ConnectionRequestService} from "../connection-request.service";
import {UserDataService} from "../user-data.service";
import {ConnectionRequest} from "../ConnectionRequest/connectionrequest";
import {User} from "../User/user";
import {proffessional} from "../Proffessional/proffessional";
import {Post} from "../Post/post";
import {forkJoin} from "rxjs";
import {PostService} from "../post.service";
import {CommentService} from "../comment.service";
import {DeclareInterestService} from "../declare-interest.service";

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  posts: Post[]= new Array<Post>();
  user:any;
  proffessionalswhorequested: User[]= new Array<User>();
  pendingrequests: ConnectionRequest[]= new Array<ConnectionRequest>();
  constructor(private crs:ConnectionRequestService,private uds:UserDataService,private ps:PostService,private cs:CommentService,private di:DeclareInterestService) { }


  ngOnInit(): void {
    this.crs.getconnectionrequests(this.uds.proffessional.id_proffessional).subscribe(cr=>{
      this.pendingrequests=cr;
      this.getproffessionals();
    })


    this.ps.getUserPosts().subscribe(data => {
      this.posts = data;

        let observables = this.posts.map(p => this.cs.getPostComments(p.id_post));
        let source = forkJoin(observables);
        source.subscribe(data => {
          for(let i = 0; i < this.posts.length; i++){
            this.posts[i].comments = data[i];
          }

          let observables2 = this.posts.map(p => this.di.getUsersFromLikes(p.id_post));
          let source2 = forkJoin(observables2);
          source2.subscribe(data => {
            for(let i = 0; i < this.posts.length; i++){
              this.posts[i].hasLiked = data[i];
            }

            let observables3 = this.posts.map(p => this.cs.getUsersFromComments(p.id_post));
            let source3 = forkJoin(observables3);
            source3.subscribe(data => {
              for(let i = 0; i < this.posts.length; i++){
                this.posts[i].hasCommented = data[i];
              }
            });
          });
        });
    });


  }

  onClickAcceptConnectionRequest(cr:ConnectionRequest){
    this.crs.acceptconnectionrequest(cr.id_proffessional1,cr.id_proffessional2).subscribe(() => {
      this.ngOnInit();
    })
  }

  onClickRejectConnectionRequest(cr:ConnectionRequest){
    this.crs.rejectconnectionrequest(cr.id_proffessional1,cr.id_proffessional2).subscribe(() => {
      this.ngOnInit();
    })
  }

  getproffessionals(){
    for(let i = 0; i < this.pendingrequests.length; i++){
      this.uds.getUserFromProf(this.pendingrequests[i].id_proffessional1).subscribe(user =>{
        this.user=user;
        this.proffessionalswhorequested.push(this.user);
      })
    }
  }

}
