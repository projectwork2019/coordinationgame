import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
import { Selection, Category, GameSession, Game, GameSessionSettings } from './game';

//const endpoint = "https://projectwork-coordinationgame.herokuapp.com/api";
const endpoint = "http://"+window.location.hostname+":8080/api";
//const endpoing = "http://195.148.31.1:8080/api";
//const endpoint = "http://195.148.31.1:8080/api";
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
	
	getGamesForSession() : Observable<any> {
		return this.http.get(endpoint + "/gamesessions").pipe(
		map(this.extractData));
	}
	
	getGame(id : number) : Observable<any>{
		return this.http.get(endpoint + "/games/" + id).pipe(
		map(this.extractData));
	}

	deleteGame(id:number) : Observable<any> {
		return this.http.get(endpoint + "/games/delete?id=" + id).pipe(
		map(this.extractData));
	}
	
	toggleEnabled(id:number) : Observable<any> {
		return this.http.get(endpoint + "/games/enable?id=" + id).pipe(
		map(this.extractData));
	}
	
	postSession(data : GameSession) : Observable<any> {
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
	
	getGameReport(id : number) : Observable<any>{
		return this.http.get(endpoint + "/games/" + id + "/report").pipe(
		map(this.extractData));
	}

	getPresentationReport(id : number) : Observable<any>{
		return this.http.get(endpoint + "/presentations/" + id + "/report").pipe(
		map(this.extractData));
	}

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
        
    getCategory(id:number) : Observable<any> {
		return this.http.get(endpoint + "/categories/"+ id).pipe(
		map(this.extractData));
	}
	
	// http method is GET -> Should be changed to DELETE
	deleteCategory(id:number) : Observable<any> {
		return this.http.get(endpoint + "/categories/delete?id=" + id).pipe(
		map(this.extractData));
	}
	
	updateGameCategories(data : Game) : Observable<any> {
		return this.http.post(endpoint + "/games/categories", data);
	}

	addOrUpdateGameSessionSettings(data : GameSessionSettings) : Observable<any> {
		return this.http.post(endpoint + "/gamesessions/settings", data);
	}

	getGameSessionDefaultSettings() : Observable<any> {
		return this.http.get(endpoint + "/gamesessions/settings").pipe(
		map(this.extractData));
	}

	getGameSessionSettings(id : number) : Observable<any> {
		return this.http.get(endpoint + "/gamesessions/settings/id").pipe(
		map(this.extractData));
	}
        
        postAnswers(data) : Observable<any> {
		return this.http.post(endpoint + "/gamesessions", data);
	}
        
//        getGameReport(id : number) : Observable<any>{
//                return this.http.get(endpoint + "/games/" + id + "/report").pipe(
//                map(this.extractData));
//        }

//        getPresentationReport(id : number) : Observable<any>{
//                return this.http.get(endpoint + "/presentations/" + id + "/report").pipe(
//                map(this.extractData));
//        }
        
        getPresentationsByGameId(id : number) : Observable<any>{
                return this.http.get(endpoint + "/games/" + id + "/presentations").pipe(
                map(this.extractData));
				}
				
				isAuthenticated() : Observable<any> {
					return this.http.get(endpoint + "/user").pipe(
						map(this.extractData));
				}
}
