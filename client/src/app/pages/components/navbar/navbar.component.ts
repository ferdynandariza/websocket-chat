import { Component } from '@angular/core';
import {AuthService} from '../../../services/auth.service';

@Component({
  selector: 'app-navbar',
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(
    private readonly authService: AuthService,
  ) {}

  onClickLogout() {
    this.authService.handleLogOut();
  }
}
