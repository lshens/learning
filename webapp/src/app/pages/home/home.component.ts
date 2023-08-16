import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from 'src/app/models/course.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
})
export class HomeComponent implements OnInit {
  courses: Course[] = [];
  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.courses = this.route.snapshot.data['courses'];
  }
}
