export class proffessional{
    id_proffessional: Number;
    id_user: Number;
    id_information_page: Number;

    constructor(id_user: Number, id_information_page: Number){
        this.id_proffessional = 0;
        this.id_user = id_user;
        this.id_information_page = id_information_page;
    }

    set(id_proffessional: Number, id_user: Number, id_information_page: Number){
        this.id_proffessional = id_proffessional;
        this.id_user = id_user;
        this.id_information_page = id_information_page;
    }
}
