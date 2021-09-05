export class proffessional{
    proffessional_id: Number;
    user_id: Number;
    informationPage_id: Number;

    constructor(user_id: Number, informationPage_id: Number){
        this.proffessional_id = 0;
        this.user_id = user_id;
        this.informationPage_id = informationPage_id;
    }
}
