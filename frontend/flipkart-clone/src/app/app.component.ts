import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CategoryComponent } from './category/category.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
  // styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'flipkart-clone';
}
