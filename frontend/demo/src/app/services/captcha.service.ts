import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CaptchaService {

  constructor() { }
  public generateCode():string{
    var a = Math.random() * 10;
    var b = Math.random() * 10;
    var c = Math.random() * 10;
    var d = Math.random() * 10;
    var e = Math.random() * 10;

    var code:string = `${Math.round(a)} - ${Math.round(b)} - ${Math.round(c)} - ${Math.round(d)} - ${Math.round(e)}`
    return code;
  }
}
