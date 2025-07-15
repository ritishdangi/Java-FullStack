import { Routes } from '@angular/router';
import { DirectiveComponent } from './directive/directive.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { EmployeeComponent } from './employee/employee.component';
import { InsertEmpComponent } from './insert-emp/insert-emp.component';
import { LoginComponent } from './login/login.component';
import { GetAllEmpComponent } from './get-all-emp/get-all-emp.component';
import { Component } from '@angular/core';
import { FirstComponent } from './first/first.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';
import { DeleteEmpComponent } from './delete-emp/delete-emp.component';

export const routes: Routes = [
  // { path: 'directive', component: DirectiveComponent },
  // { path: 'product', component: ProductDetailsComponent },
  {path: '',component: GetAllEmpComponent},
  // {path: '**',component: FirstComponent}
  {path: 'employee',component: EmployeeComponent},
  {path: 'insertemp',component: InsertEmpComponent},
  {path: 'login',component: LoginComponent},
  {path: 'update',component: UpdateEmpComponent},
  {path: 'delete',component: DeleteEmpComponent},
  {path: 'list',component: GetAllEmpComponent},
  {path: '**',component: GetAllEmpComponent}
];
