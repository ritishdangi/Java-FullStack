import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-category',
  imports: [FooterComponent],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  constructor(private router:Router){}
  Electronics(){
    this.router.navigate(['/electronics']);
  }
  mobiles(){
    this.router.navigate(['/mobile']);
  }
  monitor(){
    this.router.navigate(['/monitor']);
  }
  fashions(){
    this.router.navigate(['/fashion']);
  }
  furniture(){
    this.router.navigate(['/furniture']);
  }
  beauty(){
    this.router.navigate(['/beauty']);
  }
  homeItems(){
    this.router.navigate(['homeItems']);
  }
  books(){
    this.router.navigate(['/booksItem']);
  }
}
