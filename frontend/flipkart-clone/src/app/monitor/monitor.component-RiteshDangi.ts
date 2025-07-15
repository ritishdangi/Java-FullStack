import { Component } from '@angular/core';
import { MonitorDetails } from '../contract/monitorDetails';
import { MonitorService } from '../../services/monitor.service';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-monitor',
  imports: [CommonModule,NavbarComponent,FooterComponent],
  templateUrl: './monitor.component.html',
  styleUrl: './monitor.component.css'
})
export class MonitorComponent {
  public details : MonitorDetails [] = [];

  constructor(private serv : MonitorService){}

  ngOnInit(){
    