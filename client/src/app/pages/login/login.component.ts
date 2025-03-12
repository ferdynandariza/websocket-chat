import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    NgClass,
  ],
  providers: [AuthService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
  });

  returnUrl: string = '/home';

  constructor(
    private readonly router: Router,
    private readonly route: ActivatedRoute,
    private readonly authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
  }

  get username(): FormControl {
    return this.loginForm?.get('username') as FormControl;
  }

  get password(): FormControl {
    return this.loginForm?.get('password') as FormControl;
  }

  protected onClickLogin(): void {
    const payload = {
      username: this.username?.value as string,
      password: this.password?.value as string
    };
    this.authService.login(payload).subscribe(
      {
        next: (res) => {
          this.authService.setToken(res.token);
          this.router.navigate([this.returnUrl]);
        },
        error: (err) => {
          console.error(err);
        }
      }
    )
  }

}
