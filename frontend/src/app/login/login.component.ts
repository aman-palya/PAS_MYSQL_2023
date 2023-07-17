import { style } from '@angular/animations';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  public loginForm!: FormGroup;
  error: string | undefined;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }
  login() {
   
    // this.router.navigate(['home']);
    
    this.http
      .post('http://localhost:8085/authenticate', this.loginForm.value)
      .subscribe(
        (res: any) => {
          if (res.token != null) {
            this.loginForm.reset();
            localStorage.setItem('token', res.token);
            console.log(localStorage.getItem('token'))
            this.router.navigate(['home']);
          } else {
            // this.error = 'Username or Password is incorrect';
            alert('Username or Password is incorrect');
          }
        },
        (err) => {
          // this.error = 'User not present Please register';
          alert('Invalid Username and password');
        }
      );
  }
}
