import { CourseStatusEnum } from './course-status.enum.model';

export interface Course {
  id: string;
  name: string;
  startDate: Date;
  status?: CourseStatusEnum;
}
