import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { SessionService } from '../services/session.sevice';

@Injectable()
export class HttpHeaderService implements HttpInterceptor {
  constructor(private session: SessionService) {}

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const clone = request.clone({
      url: `${environment.server}${request.url}`,
      headers: this.getHeaders(request),
    });

    return next.handle(clone);
  }

  private getHeaders(request: HttpRequest<any>): HttpHeaders | undefined {
    let headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    if (!request.url.endsWith('/v1/users') && request.method != 'POST') {
      headers = headers.set('Authorization', `Basic ${this.session.secret}`);
    }
    return headers;
  }
}
