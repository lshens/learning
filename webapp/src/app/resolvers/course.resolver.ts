import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CourseService } from '../services/course.service';
import { Course } from '../models/course.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseResolver implements Resolve<Course[]> {

  constructor(private service: CourseService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Course[] | Observable<Course[]>{
    return this.service.findAll().pipe(map(courses =>  courses));
  }
}
