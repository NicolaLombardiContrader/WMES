import { Injectable } from '@angular/core';
import { logging } from 'protractor';
import { environment } from '../models/environment.models';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of, BehaviorSubject } from 'rxjs';


@Injectable({
    providedIn: 'root'
})
export class UserService {
    private urlBase = environment.url;

    constructor(private http: HttpClient) { }

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            console.log('${operation} failed: ${error.message}');
            return of(result as T);
        };
    }

    isLogged(): boolean {
        if (typeof (Storage) !== 'undefined') {
            if (sessionStorage.getItem('user') != null) {
                return true;
            }
            // tslint:disable-next-line:align
        } return false;
    }


}




