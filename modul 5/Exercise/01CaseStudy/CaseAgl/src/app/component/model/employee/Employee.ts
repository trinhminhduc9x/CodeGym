import {EducationDegree} from "./EducationDegree";
import {Division} from "./Division";
import {Position} from "./Position";
export interface Employee {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  idCard?: string;
  salary?: number;
  phoneNumber?: string;
  email?: string;
  address?: string;
  position?: Position;
  educationDegree?: EducationDegree;
  division?: Division;
}
