import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { formatDate } from '@angular/common';

import { httpOptions } from './httpOptions';
import { Message } from './Messages/message';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private backend_url = "http://localhost:8080/messages"

  constructor(private http: HttpClient) { }

  getMessages(id_disc: Number){
    return this.http.get<Message[]>(this.backend_url+"/disc-"+id_disc, {'headers': httpOptions});
  }
  
  sendMessage(id_disc: Number, id_sender: Number, message: String){
    let msg = {"id_discussion": id_disc, "id_sender": id_sender, "message": message, "dt": formatDate(new Date(), "YYYY-MM-dd hh:mm:ss", "en-US")};
    return this.http.post<Message>(this.backend_url, msg, {'headers': httpOptions});
  }

}
