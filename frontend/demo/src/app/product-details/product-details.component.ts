import { Component } from '@angular/core';
import { ProductDetails } from '../contract/product.contract';
import { ProductService } from '../services/product.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product-details',
  imports: [CommonModule,FormsModule],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent{
  public products:ProductDetails[] = [];

  id:number = 0;
  constructor(private _service:ProductService){}
  ngOnInit(){
    this._service.getProducts().subscribe(data=>{
      this.products=data});
  }
  getProductById(){
    if(this.id){
      this._service.getProductById(this.id).subscribe(data=>{
        this.products=[data]
      });
    }
  }
}
