import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductDetails } from '../contract/product.contract';

@Component({
  selector: 'app-employee',
  imports: [FormsModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  firstName:string="Ritesh";
  lastName:string="Dangi";
  email:string="ritishdangi@gmail.com";
  dob:string="13/11/2001";
  city:string="Indore";
  public product:ProductDetails = 
  {
    "id": 0,
    "title": "string",
    "price": 0.1,
    "description": "string",
    "category": "string",
    "image": "http://example.com"
  }
  ngOnInit(){
    fetch('https://fakestoreapi.com/products/1')
    .then(response => response.json())
    .then(data => {this.product=data});
  }
}