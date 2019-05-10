/*
 * The page for asking background info from players. 
 */
import { Component, OnInit } from '@angular/core';
import { Router,
         NavigationExtras } from '@angular/router';
import { CoordinationRestService } from '../coordination-rest.service';
//import { GameSession } from '...../src/main/java/com/projectwork/coordinationgame/model/GameSession.java'
import { FeedbackPageAnswers } from '../game';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-coord-games-feedback-page',
  templateUrl: './coord-games-feedback-page.component.html',
  styleUrls: ['./coord-games-feedback-page.component.css']
})
export class CoordGamesFeedbackPageComponent implements OnInit {

  constructor(private http: CoordinationRestService, private router: Router) { }
  
  form: NgForm;
  data: FeedbackPageAnswers;
  firstTime: string;
  readResearch: string;
  booleanFirst: boolean;
  booleanResearch: boolean;
  

  ngOnInit() {
  }
  
  submitAnswersButtonClicked() {
      
      if (this.firstTime == "true") {
          this.booleanFirst = true;
      }
      else {
          this.booleanFirst = false;
      }
      
      if (this.readResearch == "true") {
          this.booleanResearch = true;
      }
      else {
          this.booleanResearch = false;
      }
      let data = new FeedbackPageAnswers(this.booleanFirst, this.booleanResearch);
      console.log(data);
      this.http.postAnswers(data);
      
      //let dateFormat = require('dateformat');
      let now = new Date();
      console.log(now);
      this.http.postAnswers(now);
      
      let redirect = '/coord-games-final-page';

      // Set our navigation extras object
      // that passes on our global query params and fragment
      let navigationExtras: NavigationExtras = {
        queryParamsHandling: 'preserve',
        preserveFragment: true
      };

      // Redirect the user
      this.router.navigate([redirect], navigationExtras);
  }

}
