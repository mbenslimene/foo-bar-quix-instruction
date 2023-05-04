import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Result} from './model/result';

@Injectable({
  providedIn: 'root'
})
export class FooBarQuixService {

  constructor(private http: HttpClient, @Inject('SERVER_URL') private serverUrl: string) { }

  convertNumber(inputNumber: number): Observable<Result> {
    const url = `${this.serverUrl}/foo-bar-quix/${inputNumber}`;
    return this.http.get<Result>(url);
  }

}
