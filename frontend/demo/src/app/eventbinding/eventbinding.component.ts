import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ProductDetails } from '../contract/product.contract';

@Component({
  selector: 'app-eventbinding',
  imports: [FormsModule,CommonModule],
  templateUrl: './eventbinding.component.html',
  styleUrl: './eventbinding.component.css'
})
export class EventbindingComponent {
  product:ProductDetails[] = [];

  ngOnInit(){
    this.getProduct();
  }

  getProduct(){
    fetch('https://fakestoreapi.com/products')
    .then(response => response.json())
    .then(data => {this.product=data});
  }
  public hello(e:any){
    if(e.target.id=="btnHello")
      alert("hello")
    else if(e.target.id=="btnWelcome")
    alert("welcom")
  }
}
