import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";

import { of } from "rxjs/internal/observable/of";
import { catchError, tap } from "rxjs/operators";
import { Observable } from "rxjs/internal/Observable";

import { Gym } from "../../models/Gym";

@Injectable({
  providedIn: 'root'
})
export class GymService {

  private baseGymUrl = 'http://localhost:60003/gyms';

  constructor(private http: HttpClient) { }

  findGyms(gym: string): Observable<Gym[]> {
    return this.http.post<any>(`${this.baseGymUrl}`, {'gym': gym})
      .pipe(
        tap(_ => console.log(`Gyms found`)),
        catchError(response => this.handleError(response))
      );
  }

  private handleError<T> (error: HttpErrorResponse, result?: T) {
    console.error(error);
    console.error(error.error['error']);
    console.error(error.error['message']);
    return of(result as T);
  }

}
