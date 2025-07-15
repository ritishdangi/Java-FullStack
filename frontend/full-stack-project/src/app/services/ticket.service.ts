import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../contract/Ticket';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  private url = 'http://localhost:8080/ticket';
  private baseurl = 'http://localhost:8080/auth';
  constructor(private http: HttpClient) {}

  createTicket(ticket: Partial<Ticket>): Observable<Ticket> {
    return this.http.post<Ticket>(`${this.url}/create`, ticket);
  }
  getTicketsByUser(userId: number): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${this.url}/user/${userId}`);
  }
  getAllCustomer(id: any): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/auth/get?userId=${id}`);
  }
  getUserById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseurl}/get/${id}`);
  }
  getAllCsr(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseurl}/getCsr`);
  }
  assignTicket(ticketId: number, csrId: number, adminId: number) {
    return this.http.post(
      `http://localhost:8080/ticket/assign/${ticketId}/${csrId}?adminId=${adminId}`,
      null
    );
  }
  getTicketsAssignedToCsr(csrId: number): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(
      `http://localhost:8080/ticket/assigned/${csrId}`
    );
  }

  updateTicketStatus(ticketId: number, status: string): Observable<any> {
  return this.http.put(`${this.url}/update/${ticketId}/status?status=${status}`, {});
}

  getAllTicket() : Observable<Ticket[]>{
    return this.http.get<Ticket[]>(`${this.url}/get`);
  }
}
