import {Component, OnDestroy} from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule, ValidationErrors,
  ValidatorFn,
  Validators
} from "@angular/forms";
import {NgClass} from '@angular/common';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnDestroy {

  registerForm: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    repeatPassword: new FormControl('', [Validators.required, this.passwordMatch()]),
  });


  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
    ) {}

  onClickRegister(): void {
    this.fetchRegister();
  }

  private fetchRegister(): void {
    this.authService.register(this.registerForm.value).subscribe(
      {
        next: (res) => {
          this.router.navigate(['/login']);
        },
        error: (err) => {}
      }
    )
  }

  get password() {
    return this.registerForm?.get('password') as FormGroup;
  }

  get repeatPassword() {
    return this.registerForm?.get('repeatPassword') as FormGroup;
  }

  private passwordMatch(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const notMatch = this.password?.value !== this.repeatPassword?.value;
      return notMatch ? { notMatch: { value: control.value } } : null;
    };
  }

  ngOnDestroy(): void {
    this.registerForm.reset();
  }
}
