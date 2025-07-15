import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductDetails } from '../contract/product.contract';
import id from '@angular/common/locales/extra/id';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url:string = "https://fakestoreapi.com/products";
  constructor(private _http:HttpClient) { }

  public getProducts():Observable<ProductDetails[]>{
    return this._http.get<ProductDetails[]>(this.url);
  }
  public getProductById(id: number):Observable<ProductDetails>{
    return this._http.get<ProductDetails>(`${this.url}/${id}`);
    

  }
}
