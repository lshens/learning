import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LevelService } from '../../services/level.service';
import { LevelEnum } from '../../models/level.enum.model';

import { Subscription } from 'rxjs';
import { SessionService } from '../../services/session.sevice';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit, OnDestroy {
  form: FormGroup = new FormGroup({});
  loading: boolean = false;

  private subscriptions: Subscription[] = [];

  constructor(
    private builder: FormBuilder,
    private session: SessionService,
    private service: LevelService
  ) {}

  ngOnInit(): void {
    this.form = this.builder.group({
      email: ['', [Validators.required, Validators.email]],
      secret: ['', Validators.required],
    });
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription: Subscription) =>
      subscription.unsubscribe()
    );
  }

  onSubmit(): void {
    if (this.form.valid) {
      this.loading = true;
      const data = this.form.value;
      this.session.secret = btoa(`${data.email}:${data.secret}`);
      this.subscriptions.push(
        this.service.findAll().subscribe(
          (levels: LevelEnum[]) => {
            this.session.levels = levels;
            this.loading = false;
          },

          (error) => {
            // pause loader and show the error message;
            this.loading = false;
          }
        )
      );
    }
  }
}
