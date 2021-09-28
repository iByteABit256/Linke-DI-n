import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import { Message } from './Messages/message';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private backend_url = "http://localhost:8080/messages"

  constructor(private http: HttpClient) { }

  getDiscussions(id_disc: Number){
    return this.http.get<Message[]>(this.backend_url+"/disc-"+id_disc, {'headers': httpOptions});
  }

}
