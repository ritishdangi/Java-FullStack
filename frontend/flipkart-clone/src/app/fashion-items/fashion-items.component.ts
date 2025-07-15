import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-fashion-items',
  imports: [NavbarComponent,FooterComponent],
  templateUrl: './fashion-items.component.html',
  styleUrl: './fashion-items.component.css'
})
export class FashionItemsComponent {

}
