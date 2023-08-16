import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from '../models/address.model';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  private uri = '/v1/users/addresses';

  constructor(private http: HttpClient) {}

  create(address: Address): Observable<Address> {
    return this.http.post<Address>(this.uri, address);
  }

  update(address: Address): Observable<Address> {
    return this.http.put<Address>(this.uri, address);
  }

  findOne(): Observable<Address> {
    return this.http.get<Address>(this.uri);
  }
}
