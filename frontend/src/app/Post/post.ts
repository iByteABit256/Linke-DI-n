export class Post{
    id_proffessional: Number;
    title: String;
    body: String;
    dt: String;

    constructor(id_proffessional: Number, title: String, body: String, dt: String){
        this.id_proffessional = id_proffessional;
        this.title = title;
        this.body = body;
        this.dt = dt;
    }
}