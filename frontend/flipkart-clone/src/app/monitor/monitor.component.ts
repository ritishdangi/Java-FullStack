import { Component } from '@angular/core';
import { MonitorDetails } from '../contract/monitorDetails';
import { MonitorService } from '../../services/monitor.service';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-monitor',
  imports: [CommonModule,NavbarComponent],
  templateUrl: './monitor.component.html',
  styleUrl: './monitor.component.css'
})
export class MonitorComponent {
  public details : MonitorDetails [] = [];

  constructor(private serv : MonitorService){}

  ngOnInit(){
    this.serv.getProducts().subscribe(data=>{
      this.details=data});
  }
}
