import { Comment } from "../Comment/comment";
import {User} from "../User/user";

export class Post{
    id_post: Number;
    id_proffessional: Number;
    title: String;
    body: String;
    dt: String;
    comments: Comment[];
    hasCommented: User[];
    hasLiked: User[];
    likes: Number;
    recommended: Boolean;

    constructor(id_proffessional: Number, title: String, body: String, dt: String){
        this.id_post = 0;
        this.id_proffessional = id_proffessional;
        this.title = title;
        this.body = body;
        this.dt = dt;
        this.comments = [];
        this.hasCommented=[];
        this.hasLiked=[];
        this.likes = -1;
        this.recommended = false;
    }
}
