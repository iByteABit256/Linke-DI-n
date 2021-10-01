import { LoginPageComponent } from "../login-page/login-page.component";
import { User } from "../User/user";

export class Discussion{
    id_discussion: Number;
    id_proffessional1: Number;
    id_proffessional2: Number;
    otherUser: any;
    
    constructor(id_proffessional1: Number, id_proffessional2: Number){
        this.id_discussion = 0;
        this. id_proffessional1 = id_proffessional1;
        this.id_proffessional2 = id_proffessional2;
    }
}
