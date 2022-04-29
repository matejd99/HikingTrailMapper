import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class UserService {
  private user: any | undefined;

  constructor(private httpClient: HttpClient) {}

  public isLogedIn(): boolean {
    return this.user;
  }
}
