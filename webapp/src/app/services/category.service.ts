import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from '../models/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private uri = '/v1/tasks';

  constructor(private http: HttpClient) {}

  findAll(start: number = 0, end: number = 20): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.uri}?start=${start}&end=${end}`);
  }
}
