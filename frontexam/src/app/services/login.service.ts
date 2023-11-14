import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public logingStatusSubject = new Subject<boolean>();

  constructor(private http: HttpClient) { }

  public getCurrentUser() {
   return this.http.get(`${baseUrl}/current-user`) 
  }

  // genereate tocken
  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData)
  }

  // loging user: set tocken in local sotrage
  public loginUser(token: any) {
    localStorage.setItem('token', token);
    return true;
  }

  // user is logged in or not
  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token")
    if (tokenStr == undefined || tokenStr == null || tokenStr == "") {
      return false;
    }
    else {
      return true;
    }
  }

  // logout: remove token form local storage
  public logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  // get token
  public getToken() {
    return localStorage.getItem('token');
  }

  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  // get user role
  public getUserRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}
