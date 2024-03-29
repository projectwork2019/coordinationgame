import { Component }        from '@angular/core';
import { Router,
         NavigationExtras } from '@angular/router';
import { AuthService }      from '../auth.service';
//import { MaterialModule } from '.../material.module';

//import { NgModule } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  message: string;
  user: string; 
  psw: string; 
  playerId: string;

  credentials = {username: '', password: ''};

  constructor(public authService: AuthService, public router: Router) {
  }

  setMessage() {
  }

  login(username : string, password : string) {
    this.message = 'Trying to log in ...';
    
    this.user = username; //temporary code - for testing only. Will be removed later.
    this.psw = password; //temporary code - for testing only. Will be removed later.
    this.credentials.username = username;
    this.credentials.password = password;
    console.log(this.user); //temporary code - for testing only. Will be removed later.
    console.log(this.psw); //temporary code - for testing only. Will be removed later.
    
    //this.psw = document.getElementById(password).value;

    this.authService.authenticate(this.credentials,() => {
        this.router.navigateByUrl('/coord-games-admin-games-page');
      });
      return false;
    }
      /*
      this.setMessage();
      if (this.authService.isLoggedIn) {
          
          this.user = 'username; //temporary code - for testing only. Will be removed later.
          this.psw = 'Password: ' + password; //temporary code - for testing only. Will be removed later.

        // Get the redirect URL from our auth service
        // If no redirect has been set, use the default
        let redirect = this.authService.redirectUrl ? this.authService.redirectUrl : '/coord-games-admin-games-page';

        // Set our navigation extras object
        // that passes on our global query params and fragment
        let navigationExtras: NavigationExtras = {
          queryParamsHandling: 'preserve',
          preserveFragment: true
        };

        // Redirect the user
        this.router.navigate([redirect], navigationExtras);
      }
    });*/
  }

  /*logout() {
    this.authService.logout();
    this.setMessage();
    
    this.router.navigate(['/coord-games-logout-page']);
  }*/



/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/