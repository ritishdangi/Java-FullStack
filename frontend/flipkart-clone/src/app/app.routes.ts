import { Routes } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ElectronicsComponent } from './electronics/electronics.component';
import { MobilesComponent } from './mobiles/mobiles.component';
import { MobileListComponent } from './mobile-list/mobile-list.component';
import { MonitorComponent } from './monitor/monitor.component';
import { FashionItemsComponent } from './fashion-items/fashion-items.component';
import { BeautyItemsComponent } from './beauty-items/beauty-items.component';
import { FurnitureItemsComponent } from './furniture-items/furniture-items.component';
import { HomeandkitchenItemsComponent } from './homeandkitchen-items/homeandkitchen-items.component';
import { BooksItemsComponent } from './books-items/books-items.component';


export const routes: Routes = [
    {path: '',component:HomeComponent},
    {path: 'electronics',component:ElectronicsComponent},
    {path: 'mobile',component:MobilesComponent},
    {path: 'phoneList/:brand',component:MobileListComponent},
    {path: 'monitor',component:MonitorComponent},
    {path: 'fashion',component:FashionItemsComponent},
    {path: 'furniture',component:FurnitureItemsComponent},
    {path: 'beauty',component:BeautyItemsComponent},
    {path: 'homeItems',component:HomeandkitchenItemsComponent},
    {path: 'booksItem',component:BooksItemsComponent}
];
