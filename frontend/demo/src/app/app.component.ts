import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FirstComponent } from './first/first.component';
import { EmployeeComponent } from './employee/employee.component';
import { GenderPipe } from './pipes/gender.pipe';
import { PipeComponent } from './pipe/pipe.component';
import { DirectiveComponent } from './directive/directive.component';
import { EventbindingComponent } from './eventbinding/eventbinding.component';
import { LoginComponent } from './login/login.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { InsertEmpComponent } from './insert-emp/insert-emp.component';
import { DeleteEmpComponent } from './delete-emp/delete-emp.component';
import { GetAllEmpComponent } from './get-all-emp/get-all-emp.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';
import { routes } from './app.routes';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'demo';
}
