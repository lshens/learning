import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileFormComponent } from './profile-form.component';
import { ButtonModule } from 'primeng-lts/button';
import { InputTextModule } from 'primeng-lts/inputtext';
import { BlockUIModule } from 'primeng-lts/blockui';
import { ReactiveFormsModule } from '@angular/forms';
import { ProfileFormRoutingModule } from './profile-form-routing.module';
import { CalendarModule } from 'primeng-lts/calendar';

@NgModule({
  declarations: [ProfileFormComponent],
  imports: [
    CommonModule,
    ProfileFormRoutingModule,
    InputTextModule,
    ButtonModule,
    BlockUIModule,
    ReactiveFormsModule,
    CalendarModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class ProfileFormModule {}
