import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BASE_URL, ENDPOINT} from '../constants/enpoint.constant';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private readonly http: HttpClient,
    private readonly router: Router
    ) {}

  public register(payload: {username: string, password: string}): Observable<any> {
    return this.http.post(BASE_URL + ENDPOINT.REGISTER, payload);
  }

  public login(payload: {username: string, password: string}): Observable<any> {
    return this.http.post(BASE_URL + ENDPOINT.LOGIN, payload);
  }

  public setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  public handleLogOut(): void {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return token ? this.isTokenExpired(token) : false;
  }

  private isTokenExpired(token: string): boolean {
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.exp < Date.now();
    } catch (e) {
      return true;
    }
  }
}
