import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-books-items',
  imports: [FooterComponent,NavbarComponent],
  templateUrl: './books-items.component.html',
  styleUrl: './books-items.component.css'
})
export class BooksItemsComponent {

}
