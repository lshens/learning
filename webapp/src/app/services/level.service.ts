import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LevelEnum } from '../models/level.enum.model';

@Injectable({
  providedIn: 'root',
})
export class LevelService {
  private uri = '/v1/users/levels';

  constructor(private http: HttpClient) {}

  findAll(): Observable<LevelEnum[]> {
    return this.http.get<LevelEnum[]>(this.uri);
  }
}
