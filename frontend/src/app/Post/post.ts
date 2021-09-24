import { Comment } from "../Comment/comment";

export class Post{
    id_post: Number;
    id_proffessional: Number;
    title: String;
    body: String;
    dt: String;
    comments: Comment[];

    constructor(id_proffessional: Number, title: String, body: String, dt: String){
        this.id_post = 0;
        this.id_proffessional = id_proffessional;
        this.title = title;
        this.body = body;
        this.dt = dt;
        this.comments = [];
    }
}