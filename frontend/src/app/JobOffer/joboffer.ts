export class JobOffer{
  id_job_offer: Number;
  id_proffessional: Number;
  title: String;
  body: String;
  applications: Number;

  constructor(id_proffessional: Number, title: String, body: String){
    this.id_job_offer = 0;
    this.id_proffessional = id_proffessional;
    this.title = title;
    this.body = body;
    this.applications=-1;
  }
}
