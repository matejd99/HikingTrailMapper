import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuardService implements CanActivate {
  constructor(public userService: UserService, public router: Router) {}
  canActivate(): boolean {
    this.userService.refresh();
    if (!this.userService.isLogedIn) {
      this.router.navigate(['log-in']);
      return false;
    }
    return true;
  }
}
