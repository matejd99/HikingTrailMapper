import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';

@Component({
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  public registerForm = this.fb.group({
    firstName: [''],
    lastName: [''],
    userName: [''],
    password: [''],
    imageUrl: [''],
  });

  constructor(private fb: FormBuilder, private userService: UserService) {}

  public onSubmit() {
    this.userService.signUp(this.registerForm.value);
  }

  ngOnInit(): void {}
}
