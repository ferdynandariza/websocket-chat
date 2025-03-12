import {HttpErrorResponse, HttpInterceptorFn, HttpStatusCode} from '@angular/common/http';
import {catchError, throwError} from 'rxjs';
import {inject} from '@angular/core';
import {AuthService} from '../services/auth.service';

export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  return next(req)
    .pipe(catchError((error: any) => {
      if (error instanceof HttpErrorResponse && error.status == HttpStatusCode.Unauthorized) {
        authService.handleLogOut();
      }
      return throwError(() => new Error(error.error?.message));
    }));
};
