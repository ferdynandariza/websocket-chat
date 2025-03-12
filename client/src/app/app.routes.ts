import { Routes } from '@angular/router';
import {LoginComponent} from './pages/login/login.component';
import {HomeComponent} from './pages/home/home.component';
import {loginGuard} from './guards/login.guard';
import {NotFoundComponent} from './pages/not-found/not-found.component';
import {homeGuard} from './guards/home.guard';
import {RegisterComponent} from './pages/register/register.component';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, canActivate: [homeGuard] },
  { path: 'register', component: RegisterComponent, canActivate: [homeGuard] },
  { path: 'not-found', component: NotFoundComponent, canActivate: [loginGuard] },
  { path: 'home', component: HomeComponent, canActivate: [loginGuard] },
  { path: '**', redirectTo: '/not-found' },
];
