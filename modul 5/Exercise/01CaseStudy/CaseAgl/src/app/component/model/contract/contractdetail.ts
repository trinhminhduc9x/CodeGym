import {Attachfacility} from "./attachfacility";
import {Contract} from "./contract";

export interface Contractdetail {
  id?: number;
  contract?: Contract;
  attachFacility?: Attachfacility;
  quantity?: number;
}
