import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData = {
    username: "",
    password: ""
  }

  constructor(private snack: MatSnackBar, private login: LoginService,  private router:Router) {
  }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log("login form submit");
    if (this.loginData.username == null || this.loginData.username.trim() == '') {
      this.snack.open("Username is reuqired !!", 'OK', {
        duration: 3000
      })
    }
    if (this.loginData.password == null || this.loginData.password.trim() == '') {
      this.snack.open("Password is reuqired !!", 'OK', {
        duration: 3000
      });
    }

    // request ot sever to genereate token
    this.login.generateToken(this.loginData).subscribe((data: any) => {
      console.log('success');
      console.log(data);

      // logging in.....
      this.login.loginUser(data.token);

      this.login.getCurrentUser().subscribe((user: any) => {
        this.login.setUser(user);
        console.log(user);
        // redirect ...ADMIN: admain-dashboard
        // redirect ...NORMAL: NORMAL-dashboard
        if (this.login.getUserRole() == 'ADMIN') {
          // admin dashboard
          // window.location.href = '/admin'
          this.login.logingStatusSubject.next(true);
          this.router.navigate(['admin'])
        } else if (this.login.getUserRole() == 'NORMAL') {
          // normal user dashboard
          // window.location.href = '/user-dashboard'
          this.login.logingStatusSubject.next(true);
          this.router.navigate(['user-dashboard'])
        } else {
          this.login.logout();
        }
      });

    },
      (error) => {
        console.log("error!!");
        console.log(error);
        this.snack.open("Invalid Details!! Try again!!", "", {
          duration: 3000
        })
      });
  }

}
