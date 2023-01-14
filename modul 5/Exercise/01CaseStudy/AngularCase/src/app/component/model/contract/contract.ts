import {Employee} from '../employee/Employee';
import {Customer} from '../customer/customer';
import {Facility} from '../facility/Facility';


export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;
}
