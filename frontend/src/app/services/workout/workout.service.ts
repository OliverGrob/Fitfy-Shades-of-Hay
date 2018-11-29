import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";

import { of } from "rxjs/internal/observable/of";
import { catchError, tap } from "rxjs/operators";
import { Observable } from "rxjs/internal/Observable";

import { Workout } from "../../models/Workout";

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  private baseWorkoutUrl = 'http://localhost:60002/workout';

  constructor(private http: HttpClient) { }

  getWorkout(): Observable<Workout[]> {
    return this.http.get<any>(`${this.baseWorkoutUrl}`)
      .pipe(
        tap(_ => console.log(`Workouts found`)),
        catchError(response => this.handleError(response))
      );
  }

  addWorkout(name: string, description: string, exercises: string[], day: string): Observable<any> {
    console.log(exercises);
    return this.http.post<any>(`${this.baseWorkoutUrl}`,
      {'name': name, 'description': description, 'exercises': exercises, 'day': day})
      .pipe(
        tap(_ => console.log(`Workout added`)),
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
