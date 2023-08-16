import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Profile } from '../models/profile.model';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  private uri = '/v1/users';

  constructor(private http: HttpClient) {}

  create(profile: Profile): Observable<Profile> {
    return this.http.post<Profile>(this.uri, profile);
  }

  update(profile: Profile): Observable<Profile> {
    return this.http.put<Profile>(this.uri, profile);
  }

  findOne(): Observable<Profile> {
    return this.http.get<Profile>(this.uri);
  }
}
