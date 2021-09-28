import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { httpOptions } from './httpOptions';
import { Discussion } from './Discussion/discussion';


@Injectable({
  providedIn: 'root'
})
export class DiscussionService {

  private backend_url = "http://localhost:8080/discussions"

  constructor(private http: HttpClient) { }

  getDiscussions(id_prof: Number){
    return this.http.get<Discussion[]>(this.backend_url+"/sender-"+id_prof, {'headers': httpOptions});
  }

}
