import { Component } from '@angular/core';
import { GenderPipe } from '../pipes/gender.pipe';

@Component({
  selector: 'app-pipe',
  imports: [GenderPipe],
  templateUrl: './pipe.component.html',
  styleUrl: './pipe.component.css',
  standalone: true
})
export class PipeComponent {
  firstName = "Ritesh";
  
  handleClick() {
    // Toggle between different names to demonstrate the pipe
    this.firstName = this.firstName === "Ritesh" ? "Dangi" : "Ritesh";
  }

  getGender(): string {
    return this.firstName === "Dangi" ? "Female" : "Male";
  }
}
