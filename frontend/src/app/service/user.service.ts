import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LogInRequest, SignUpRequest } from '../contracts/requests';
import { User } from '../contracts/models';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class UserService {
  public logedInUser: User | undefined;

  constructor(private httpClient: HttpClient, private router: Router) {}

  public isLogedIn(): boolean {
    return !!this.logedInUser;
  }

  public logIn(request: LogInRequest): void {
    this.httpClient.post<User>('http://localhost:7070/user/log-in', request).subscribe(
      (user: User) => {
        this.logedInUser = user;
        this.router.navigate(['']);
      },
      (err) => {
        console.error(err);
      }
    );
  }

  public signUp(request: SignUpRequest): void {
    this.httpClient.post<User>('http://localhost:7070/user/sign-up', request).subscribe(
      (user: User) => {
        this.logedInUser = user;
        this.router.navigate(['']);
      },
      (err) => {
        console.error(err);
      }
    );
  }
}
