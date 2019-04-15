import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
import { Selection, Category } from './game';

const endpoint = "https://projectwork-coordinationgame.herokuapp.com/api";
const httpOptions = {
	headers: new HttpHeaders({
		'Content-Type':  'application/json'
	})
};

@Injectable({
  providedIn: 'root'
})

export class CoordinationRestService {
	
	constructor(private http: HttpClient) { }
	
	private extractData(res: Response) {
		let body = res;
		return body || { };
	}
  
	addOrEditGame(data) : Observable<any> {
		return this.http.post(endpoint + "/games", data);
	}
	
	removeGame(data) : Observable<any> {
		return this.http.post(endpoint + "/games", data);
	}

	getGames() : Observable<any> {
		return this.http.get(endpoint + "/games").pipe(
		map(this.extractData));
	}
	
	getGame(id : number) : Observable<any>{
		return this.http.get(endpoint + "/games/" + id).pipe(
		map(this.extractData));
	}
	
	postSession(data : any[]) : Observable<any> {
		console.log("POSTING SESSION: " + data);
		return this.http.post(endpoint + "/gamesessions", data);
	}
	
	getSession(id : number) : Observable<any> {
		return this.http.get(endpoint + "/gamesessions/" + id).pipe(
		map(this.extractData));
	}
	
	/*postAdditionalInformation(data) : Observable<any> {
		return this.http.post(endpoint + "/gameSession/additionalInfo", data);
	}*/
	
	postComment(data) : Observable<any> {
		return this.http.post(endpoint + "/comments", data);
	}
	
	getComments() : Observable<any> {
		return this.http.get(endpoint + "/comments").pipe(
		map(this.extractData));
	}
	
	addCategory(data : Category) : Observable<any> {
		return this.http.post(endpoint + "/categories", data);
	}
	
	getCategories() : Observable<any> {
		return this.http.get(endpoint + "/categories").pipe(
		map(this.extractData));
	}
        
        postAnswers(data) : Observable<any> {
		return this.http.post(endpoint + "/gamesessions", data);
	}
}
