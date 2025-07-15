import { Component, OnInit } from '@angular/core';
import { EmpService } from '../services/emp.service';
import { Observable } from 'rxjs';
import { Employe } from '../contract/Employe.contract';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { UpdateEmpComponent } from '../update-emp/update-emp.component';

@Component({
  selector: 'app-get-all-emp',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './get-all-emp.component.html',
  styleUrl: './get-all-emp.component.css',
})
export class GetAllEmpComponent implements OnInit{
  constructor(private serv: EmpService) {}

  ngOnInit(): void {
    this.getAll();
    throw new Error('Method not implemented.');
  }
  response: string | null = null;
  employe: Employe[] = [];
  getAll() {
    this.serv.getAllEmpData().subscribe((data) => {
      this.employe = data;
      if (this.employe.length > 0) {
        this.response = 'Employee Data Fetched';
      } else {
        this.response = 'No employees found';
      }
      setTimeout(() => {
        this.response = null;
      }, 2000);
    });
  }
}
