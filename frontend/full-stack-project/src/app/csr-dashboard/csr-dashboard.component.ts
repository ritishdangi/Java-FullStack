import { Component, OnInit } from '@angular/core';
import { TicketService } from '../services/ticket.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-csr-dashboard',
  imports: [CommonModule,FormsModule],
  templateUrl: './csr-dashboard.component.html',
  styleUrl: './csr-dashboard.component.css'
})
export class CsrDashboardComponent implements OnInit{
  tickets : any[] = [];
  csrName : string = '';
  customerName : string = '';

  constructor(private service : TicketService,private router : Router){}
  ngOnInit(): void {
    const loggedInUser = JSON.parse(localStorage.getItem('user') || '{}');
    if (!loggedInUser?.id || loggedInUser.role !== 'CSR') {
      alert('Unauthorized access');
      this.router.navigate(['/login']);
      return;
    }
    this.csrName = loggedInUser.name;
    this.service.getTicketsAssignedToCsr(loggedInUser.id).subscribe({
      next : (data) =>{
        this.tickets = data;
         this.tickets.forEach(ticket => {
        this.service.getUserById(ticket.userId).subscribe({
          next: (user) => {
            ticket.customerName = user.name; // 🟢 Set name dynamically
          },
          error: () => {
            ticket.customerName = 'Unknown';
          }
        });
      });
    },
      error : (err) =>{
        console.log('Faild to load ticket',err);
      }
    });
  }
 updateStatus(ticketId: number, status: string): void {
    this.service.updateTicketStatus(ticketId, status).subscribe({
      next: () => {
        alert('Status updated!');
        this.ngOnInit();
      },
      error: (err) => console.error('Update failed', err)
    });
  }

  logout(): void {
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
}
