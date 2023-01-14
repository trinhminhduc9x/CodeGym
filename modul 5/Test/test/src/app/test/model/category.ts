import {Product} from './product';

export interface Category {
  id?: number;
  product?: Product;
  number?: number;
  productDay?: string;
  startDay?: string;
  endDay?: string;
}
