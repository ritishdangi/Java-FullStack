import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-first',
  imports: [FormsModule],
  templateUrl: './first.component.html',
  styleUrl: './first.component.css'
})
export class FirstComponent {
  firstName:string = "Ritesh";
  lastName:string = "Dangi";
  image="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCpBUVL0jZtPdjtthlE6EAJTExRvhrIkMtyg&s";
  testFun(){
    alert("hii");
  }
}
