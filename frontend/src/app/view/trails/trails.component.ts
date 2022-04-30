import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/contracts/models';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-trails',
  templateUrl: './trails.component.html',
  styleUrls: ['./trails.component.css']
})
export class TrailsComponent implements OnInit {
  public user?: User;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.user = this.userService.logedInUser;
  }

}
