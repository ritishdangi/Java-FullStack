import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';


@Component({
  selector: 'app-homeandkitchen-items',
  imports: [NavbarComponent,FooterComponent],
  templateUrl: './homeandkitchen-items.component.html',
  styleUrl: './homeandkitchen-items.component.css'
})
export class HomeandkitchenItemsComponent {

}
