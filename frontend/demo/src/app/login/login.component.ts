import { Component } from '@angular/core';
import { CaptchaService } from '../services/captcha.service';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public code:string="";
  constructor(private service:CaptchaService){}
  ngOnInit(){
    this.code=this.service.generateCode();
  }
  public newCode():void{
    this.code=this.service.generateCode();
  }
}
