import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LevelEnum } from '../../models/level.enum.model';
import { Subscription } from 'rxjs';
import { ProfileService } from '../../services/profile.service';
import { SessionService } from 'src/app/services/session.sevice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-form',
  templateUrl: './profile-form.component.html'
})
export class ProfileFormComponent implements OnInit, OnDestroy {
  form: FormGroup = new FormGroup({});
  loading: boolean = false;
  maxDate: Date = new Date();
  error: boolean = false;

  private subscriptions: Subscription[] = [];

  constructor(
    private builder: FormBuilder,
    private router: Router,
    private service: ProfileService,
    private session: SessionService
  ) {}

  ngOnInit(): void {
    const maxYear = this.maxDate.getFullYear() - 16;
    this.maxDate = new Date(maxYear, this.maxDate.getMonth(), this.maxDate.getDate());
    this.form = this.builder.group({
      email: ['', [Validators.required, Validators.email]],
      secret: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~]).{8,}$')]],
      dateBirth: ['', Validators.required]
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
      this.subscriptions.push(
        this.service.create(data).subscribe(
          () => {
            this.loading = false;
            this.session.secret = btoa(`${data.email}:${data.secret}`);
          },

          (error) => {
            console.debug(error);
            this.loading = false;
            this.error = true;
          }
        )
      );
    }
  }
}
