import {Contract} from './contract';
import {Attachfacility} from './attachfacility';


export interface Contractdetail {
  id?: number;
  contract?: Contract;
  attachFacility?: Attachfacility;
  quantity?: number;
}
