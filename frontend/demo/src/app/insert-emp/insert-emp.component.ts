import { Component } from '@angular/core';
import { Employe } from '../contract/Employe.contract';
import { EmpService } from '../services/emp.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-insert-emp',
  imports: [CommonModule,FormsModule],
  templateUrl: './insert-emp.component.html',
  styleUrl: './insert-emp.component.css'
})
export class InsertEmpComponent {
  public employee:Employe = {
    id:0,
    name:"",
    salary:0
  };
  response:string | null = null;
  employe: any;
  constructor(private serv:EmpService){}

  saveEmploye(emp:Employe){
    // this.response = "Employee created successfully!";
    setTimeout(() => {
      this.response = "Employee created successfully!";
      setTimeout(() => {
        this.response = null;
      }, 3000)
    }, 1000); 
    this.serv.saveEmp(emp).subscribe(data=>{this.response=data});
  }
}
