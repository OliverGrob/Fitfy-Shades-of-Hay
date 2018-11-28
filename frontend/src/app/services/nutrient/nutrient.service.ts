import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";

import { Observable } from "rxjs/internal/Observable";
import { catchError, tap } from 'rxjs/operators';
import { of } from "rxjs/internal/observable/of";

import { Nutrient } from "../../models/Nutrient";

@Injectable({
  providedIn: 'root'
})
export class NutrientService {

  private baseNutritionUrl = 'http://localhost:60001/nutrition';

  constructor(private http: HttpClient) { }

  calculateNutrients(meal: string, serving: string): Observable<Nutrient[]> {
    return this.http.post<any>(`${this.baseNutritionUrl}`, {'meal': meal, 'serving': serving})
      .pipe(
        tap(_ => console.log(`Nutrients found`)),
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
