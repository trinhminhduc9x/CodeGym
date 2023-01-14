import {Customer} from "../customer/customer";
import {Employee} from "../employee/Employee";
import {Facility} from "../facility/Facility";

export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;
}
