import { CategoryTypeEnum } from './category-type.enum.model';

export interface Category {
  id: string;
  description: string;
  type?: CategoryTypeEnum;
}
