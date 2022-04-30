import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';

@Component({
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
})
export class LogInComponent implements OnInit {
  public logInForm = this.fb.group({
    userName: [''],
    password: [''],
  });

  constructor(private fb: FormBuilder, private userService: UserService) {}

  public onSubmit() {
    this.userService.logIn(this.logInForm.value);
  }

  ngOnInit(): void {}
}
