export class Message{
    id_message: Number;
    id_discussion: Number;
    id_sender: Number;
    message: String;
    dt: String;
    
    constructor(id_discussion: Number, id_sender: Number, message: String, dt: String){
        this.id_message = 0;
        this.id_discussion = id_discussion;
        this.id_sender = id_sender;
        this.message = message;
        this.dt = dt;
    }
}
