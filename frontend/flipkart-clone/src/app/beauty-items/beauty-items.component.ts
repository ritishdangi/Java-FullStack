import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-beauty-items',
  imports: [NavbarComponent,FooterComponent],
  templateUrl: './beauty-items.component.html',
  styleUrl: './beauty-items.component.css'
})
export class BeautyItemsComponent {

}
