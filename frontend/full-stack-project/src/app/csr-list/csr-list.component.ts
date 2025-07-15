import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TicketService } from '../services/ticket.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-csr-list',
  imports: [CommonModule, FormsModule],
  templateUrl: './csr-list.component.html',
  styleUrl: './csr-list.component.css',
})
export class CsrListComponent implements OnInit {
  csrs: any[] = [];
  ticketIdToAssign: number | null = null;
  constructor(private service: TicketService, private router: Router) {}
  ngOnInit(): void {
    // Get ticket ID from router state
    this.ticketIdToAssign = history.state.ticketId;

    if (!this.ticketIdToAssign) {
      alert('Ticket ID is missing!');
      this.router.navigate(['/my-ticket']);
      return;
    }

    // Load CSR users from backend
    this.service.getAllCsr().subscribe({
      next: (data) => {
        this.csrs = data.filter((user) => user.role === 'CSR');
      },
      error: (err) => {
        console.error('Failed to load CSR users:', err);
        alert('Could not load CSR users.');
      },
    });
  }

  assignToCsr(csrId: number): void {
    const ticketId = this.ticketIdToAssign;
    const loggedInUser = JSON.parse(localStorage.getItem('user') || '{}');

    this.service.assignTicket(ticketId!, csrId, loggedInUser.id).subscribe({
      next: () => alert('Ticket assigned successfully'),
      error: (err) => console.error('Assignment failed', err),
    });
  }
}
