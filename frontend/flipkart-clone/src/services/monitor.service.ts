import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MonitorDetails } from '../app/contract/monitorDetails';

@Injectable({
  providedIn: 'root'
})
export class MonitorService {
  url:string = "https://fakestoreapi.com/products";
  constructor(private http : HttpClient) { }

  public getProducts():Observable<MonitorDetails[]>{
      return this.http.get<MonitorDetails[]>(this.url);
    }
}
