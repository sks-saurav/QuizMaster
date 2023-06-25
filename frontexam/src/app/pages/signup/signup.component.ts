import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private userService: UserService, private snack: MatSnackBar) { }

  public user = {
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    phone: ""
  }

  formSubmit() {
    console.log(this.user);
    if (this.user.username == '' || this.user.username == null) {
      this.snack.open("Username is required!", "OK", {
        duration: 3000,
        verticalPosition: "top",
        horizontalPosition: "right"
      });
      return;
    }

    // addUser : userservice
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        console.log(data);
        Swal.fire('Sucessfully Registered!!', 'User id is: ' + data.id, 'success')
      },
      (error) => {
        console.log(error);
        this.snack.open("Something Went Wrong!!", "OK", {
          duration: 3000,
          verticalPosition: "top",
          horizontalPosition: "right"
        });
      }
    );
  }



}
