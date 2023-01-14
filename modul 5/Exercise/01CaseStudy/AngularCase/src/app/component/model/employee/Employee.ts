import {EducationDegree} from './EducationDegree';
import {Division} from './Division';
import {Positionnew} from './positionnew';

export interface Employee {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  idCard?: string;
  salary?: number;
  phoneNumber?: string;
  email?: string;
  address?: string;
  educationDegree?: EducationDegree;
  division?: Division;
  position?: Positionnew;

}
