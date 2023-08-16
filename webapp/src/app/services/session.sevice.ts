import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Address } from '../models/address.model';
import { LevelEnum } from '../models/level.enum.model';
const SECRET = 'ABS';
const LVL = 'LVL';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  constructor() {}

  get secret(): string | null {
    return sessionStorage.getItem(SECRET);
  }

  set secret(secret: string | null) {
    if (secret) {
      sessionStorage.setItem(SECRET, secret);
    }
  }

  get levels(): LevelEnum[] | undefined {
    return sessionStorage
      .getItem(LVL)
      ?.split(',')
      .map((level: string) => LevelEnum[level as keyof typeof LevelEnum]);
  }

  set levels(levels: LevelEnum[] | undefined) {
    if (levels) {
      sessionStorage.setItem(
        LVL,
        levels.map((level: LevelEnum) => level.toString()).join(',')
      );
    }
  }
}
