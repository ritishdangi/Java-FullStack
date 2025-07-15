import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { CategoryComponent } from '../category/category.component';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-mobiles',
  imports: [NavbarComponent,CommonModule,FooterComponent],
  templateUrl: './mobiles.component.html',
  styleUrl: './mobiles.component.css',
})
export class MobilesComponent {
  constructor(private router:Router){}
  // selectedBrand: string = '';
  // selectedModels: { name: string; image: string }[] = [];

  // brandData: Record<string, { name: string; image: string }[]> = {
  //   iphone: [
  //     { name: 'iPhone 14', image: '/assets/mobiles/iphone14.png' },
  //     { name: 'iPhone 13', image: '/assets/mobiles/iphone13.png' },
  //     { name: 'iPhone SE', image: '/assets/mobiles/iphoneSE.png' },
  //   ],
  //   vivo: [
  //     { name: 'Vivo V29', image: '/assets/mobiles/vivov29.jpg' },
  //     { name: 'Vivo Y100', image: '/assets/phones/vivoy100.jpg' },
  //   ],
  //   oppo: [
  //     { name: 'Oppo Reno 10', image: '/assets/phones/renox10.jpg' },
  //     { name: 'Oppo F23', image: '/assets/phones/oppoF23.jpg' },
  //   ],
  // };
  selectBrand(brand:string) {
    // this.selectedBrand = brand;
    // this.selectedModels = this.bra
  }
}