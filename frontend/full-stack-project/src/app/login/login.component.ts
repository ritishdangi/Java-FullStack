import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginData = {
    email: '',
    password: '',
  };
  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (this.loginData.email && this.loginData.password) {
      this.authService
        .login(this.loginData.email, this.loginData.password)
        .subscribe({
          next: (res) => {
            alert('Login successful');
            localStorage.setItem('user', JSON.stringify(res));
            const role = res.role;
            alert(`${role}`);
            if (role === 'CUSTOMER') {
              this.router.navigate(['/customer-dashboard']);
            } else if (role === 'ADMIN') {
              this.router.navigate(['/admin-dashboard']);
            } else if (role === 'CSR') {
              this.router.navigate(['/csr-dashboard']);
            } else {
              alert('Unknown role. Cannot route.');
            }
            // this.router.navigate(['/dashboard']);
          },
          error: (err) => {
            console.error(err);
            alert('Invalid email or password');
          },
      });
    }
  }
}
