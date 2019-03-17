import { Component, OnInit } from '@angular/core';
import { Router,
         NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-coord-games-feedback-page',
  templateUrl: './coord-games-feedback-page.component.html',
  styleUrls: ['./coord-games-feedback-page.component.css']
})
export class CoordGamesFeedbackPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
//  submitAnswersButtonClicked() {
//      let redirect = '/coord-games-final-page';
//
//      // Set our navigation extras object
//      // that passes on our global query params and fragment
//      let navigationExtras: NavigationExtras = {
//        queryParamsHandling: 'preserve',
//        preserveFragment: true
//      };
//
//      // Redirect the user
//      this.router.navigate([redirect], navigationExtras);
//  }

}
