import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private uri = '/v1/courses';

  constructor(private http: HttpClient) {}

  create(course: Course): Observable<Course> {
    return this.http.post<Course>(this.uri, course);
  }

  update(course: Course, id: string): Observable<Course> {
    return this.http.put<Course>(`${this.uri}/${id}`, course);
  }

  findAll(start: number = 0, end: number = 20): Observable<Course[]> {
    return this.http.get<Course[]>(`${this.uri}?start=${start}&end=${end}`);
  }

  findAllInProfile(start: number = 0, end: number = 20): Observable<Course[]> {
    return this.http.get<Course[]>(`/v1/users/courses?start=${start}&end=${end}`);
  }
}
