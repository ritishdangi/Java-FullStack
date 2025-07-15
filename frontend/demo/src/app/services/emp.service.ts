import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employe } from '../contract/Employe.contract';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  header = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin', '*');

  public url: string = "http://localhost:8080/Employe";

  constructor(private http: HttpClient) { }

  public saveEmp(emp:Employe):Observable<string>{
    return this.http.post<string>(this.url+"/create",emp,{headers:this.header});
  }
  public getAllEmpData(): Observable<Employe[]> {
    return this.http.get<Employe[]>(this.url+"/get", { headers: this.header });
  }
  public deleteEmployee(id:number):Observable<string>{
    return this.http.delete<string>(this.url+"/delete/"+id,{headers:this.header});
  }
  public updateEmployee(id: number, employee: Employe):Observable<string>{
    return this.http.put<string>(this.url+"/update/"+id,employee,{headers:this.header});
  }
}
