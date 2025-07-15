import { Component } from '@angular/core';
import { EmpService } from '../services/emp.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-delete-emp',
  imports: [FormsModule, CommonModule],
  templateUrl: './delete-emp.component.html',
  styleUrl: './delete-emp.component.css',
})
export class DeleteEmpComponent {
  id: any;
  employe: any;
  constructor(private serv: EmpService) {}
  response: string | null = null;
  error: string | null = null;

  delete(id: number) {

    this.response = null;
    this.error = null;

    this.serv.deleteEmployee(id).subscribe({
      
      error: (err) => {
        console.log('Delete error:', err);
        if (err.status === 404) {
          this.error = `Employee not found with ID: ${id}`;
          setTimeout(()=>{
            this.error = null;
          },2000);
        }else{
            this.response = "Employee Deleted Successfully";
        }
        setTimeout(()=>{
          this.response = null;
        },2000);
      },
    });
  }
}
