import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BASE_URL, ENDPOINT} from '../constants/enpoint.constant';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatListService {

  constructor(private readonly http: HttpClient) { }

  public getChatList(): Observable<any> {
    return this.http.get(BASE_URL + ENDPOINT.PING);
  }

}
