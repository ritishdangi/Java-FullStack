import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-furniture-items',
  imports: [FooterComponent,NavbarComponent],
  templateUrl: './furniture-items.component.html',
  styleUrl: './furniture-items.component.css'
})
export class FurnitureItemsComponent {

}
