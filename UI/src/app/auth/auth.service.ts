/*
 * Methods for logging in and logging out
 */
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { tap, delay } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CoordinationRestService } from '../coordination-rest.service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  authenticated = false;
  // store the URL so we can redirect after logging in
  redirectUrl: string;

  constructor(private http: HttpClient ) {
  }

  // Authentication function
  authenticate(credentials, callback) {

    // Authentication request. The backend uses spring basic auth, so basic authentication is used here.
    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    // Get authenticated user's details from server. If data is returned (contains name field), the current user is authenticated.
    this.http.get('/api/user', {headers: headers}).subscribe(response => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });

}

// Check authentication status of the user
isAuthenticated() : boolean {
  // Get the status from authentication method. Authentication request is not done, 
  // but request for user details are so that we can check if user has authenticated session
  this.authenticate(null, null);
  return this.authenticated;
}

  logout(): void {

  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/