import { Component } from '@angular/core';
import { EmpService } from '../services/emp.service';
import { Employe } from '../contract/Employe.contract';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-emp',
  imports: [FormsModule, CommonModule],
  templateUrl: './update-emp.component.html',
  styleUrl: './update-emp.component.css',
})
export class UpdateEmpComponent {
  public employee: Employe = {
    id: 0,
    name: '',
    salary: 0,
  };
  constructor(private serv: EmpService) {}
  response: string | null = null;
  error: string | null = null;

  update() {

    this.response = null;
    this.error = null;

    this.serv.updateEmployee(this.employee.id, this.employee).subscribe({
      next: (data) => {
        this.response = 'Employee Updated Successfully';
        setTimeout(()=>{
          this.response = null;
        },3000);

      },
      
      error: (err) => {
        if (err.status === 404) {
          this.error = `Employee not found with ID: ${this.employee.id}`;
        } 
        setTimeout(()=>{
          this.error = null;
        },2000);
      },
    });
  }
}
