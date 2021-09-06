export class User{
    id_user : Number;
    email : String;
    password : String;
    first_name : String;
    last_name : String;
    phone_number : String;
    profile_picture_dir : String;
    settings : String;

    constructor(/*id: Number, */email: String, password: String,
        first_name: String, last_name: String, phone_number: String,
        profile_picture_dir: String, settings: String){
            
        this.id_user = 0;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.profile_picture_dir = profile_picture_dir;
        this.settings = settings;
    }
}
