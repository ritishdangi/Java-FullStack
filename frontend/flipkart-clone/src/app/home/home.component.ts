import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { CategoryComponent } from '../category/category.component';

@Component({
  selector: 'app-home',
  imports: [NavbarComponent,CategoryComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
