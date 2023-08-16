import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private uri = '/v1/users/courses';

  constructor(private http: HttpClient) {}

  create(courseId: string, categoryId: string, task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.uri}/${courseId}/task/${categoryId}/logs`, task);
  }

  update(courseId: string, categoryId: string, taskId: string, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.uri}/${courseId}/task/${categoryId}/logs/${taskId}`, task);
  }

  delete(courseId: string, categoryId: string, taskId: string): Observable<Task> {
    return this.http.delete<Task>(`${this.uri}/${courseId}/task/${categoryId}/logs/${taskId}`);
  }

  findAll(courseId: string, start: number = 0, end: number = 20): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.uri}/${courseId}/logs?start=${start}&end=${end}`);
  }
}
