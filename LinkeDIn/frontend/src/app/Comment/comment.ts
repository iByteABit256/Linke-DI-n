export class Comment{
    id_comment: Number;
    id_proffessional: Number;
    id_post: Number;
    body: String;
    
    constructor(id_proffessional: Number, id_post: Number, body: String){
        this.id_comment = 0;
        this.id_proffessional = id_proffessional;
        this.id_post = id_post;
        this.body = body;
    }
}