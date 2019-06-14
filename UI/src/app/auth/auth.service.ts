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

  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
        authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    console.log(headers);
    this.http.get('/api/user', {headers: headers}).subscribe(response => {
        if (response['name']) {
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return callback && callback();
    });

}

isAuthenticated() : boolean {
  this.authenticate(null, null);
  return this.authenticated;
}


  /*login(credentials): Observable<boolean> {

    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});
    return of(true).pipe(
      delay(1000),
      tap(val => this.isLoggedIn = true)
    );
  }*/

  logout(): void {

  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/