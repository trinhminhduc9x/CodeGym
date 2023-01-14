import {Component, OnInit} from '@angular/core';
import {Facility} from "../../model/facility/Facility";
import {FacilityType} from "../../model/facility/FacilityType";
import {RentType} from "../../model/facility/RentType";
import {CustomerType} from "../../model/customer/CustomerType";
import {Customer} from "../../model/customer/customer";
import {EducationDegree} from "../../model/employee/EducationDegree";
import {Employee} from "../../model/employee/Employee";
import {Division} from "../../model/employee/Division";
import {Position} from "../../model/employee/Position";
import {Attachfacility} from "../../model/contract/attachfacility";
import {Contract} from "../../model/contract/contract";
import {Contractdetail} from "../../model/contract/contractdetail";


@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  diamond: CustomerType = {
    id: 1,
    name: 'Diamond'
  };
  platinum: CustomerType = {
    id: 2,
    name: 'Platinum'
  };
  gold: CustomerType = {
    id: 3,
    name: 'Gold'
  };
  silver: CustomerType = {
    id: 4,
    name: 'Silver'
  };
  member: CustomerType = {
    id: 5,
    name: 'Member'
  };

  customerList: Customer[] = [
    {
      id: 1,
      address: 'address1',
      dateOfBirth: '1970-11-07',
      email: 'thihao01@gmail.com',
      gender: false,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào1',
      phoneNumber: '0945423362'
      , customerType: this.diamond
    },
    {
      id: 2,
      address: 'address2',
      dateOfBirth: '1970-11-07',
      email: 'thihao02@gmail.com',
      gender: true,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào2',
      phoneNumber: '0945423362'
      , customerType: this.platinum
    },
    {
      id: 3,
      address: 'address3',
      dateOfBirth: '1970-11-07',
      email: 'thihao03@gmail.com',
      gender: false,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào3',
      phoneNumber: '0945423362'
      , customerType: this.gold

    },
    {
      id: 4,
      address: 'address4',
      dateOfBirth: '1970-11-07',
      email: 'thihao04@gmail.com',
      gender: true,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào4',
      phoneNumber: '0945423362'
      , customerType: this.silver

    },
    {
      id: 5,
      address: 'address5',
      dateOfBirth: '1970-11-07',
      email: 'thihao05@gmail.com',
      gender: false,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào5',
      phoneNumber: '0945423362'
      , customerType: this.member

    },
    {
      id: 6,
      address: 'address6',
      dateOfBirth: '1970-11-07',
      email: 'thihao06@gmail.com',
      gender: true,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào6',
      phoneNumber: '0945423362'
      , customerType: this.diamond
    },
    {
      id: 7,
      address: 'address7',
      dateOfBirth: '1970-11-07',
      email: 'thihao07@gmail.com',
      gender: false,
      idCard: '643431213',
      name: 'Nguyễn Thị Hào7',
      phoneNumber: '0945423362'
      , customerType: this.diamond

    },
  ];
  position1: Position = {
    id: 1,
    name: 'quản lý'
  };
  position2: Position = {
    id: 2,
    name: 'Nhân viên'
  };

  division1: Division = {
    id: 1,
    name: 'Sale Marketing'
  };
  division2: Division = {
    id: 2,
    name: 'Hành chính'
  };
  division3: Division = {
    id: 3,
    name: 'Phục vụ'
  };
  division4: Division = {
    id: 4,
    name: 'Quản lý'
  };

  educationDegree1: EducationDegree = {
    id: 1,
    name: 'Trung Cấp'
  };
  educationDegree2: EducationDegree = {
    id: 2,
    name: 'Cao Đẳng'
  };
  educationDegree3: EducationDegree = {
    id: 3,
    name: 'Đại học'
  };
  educationDegree4: EducationDegree = {
    id: 4,
    name: 'Sau Đại Học'
  };

  employeeList: Employee[] = [
    {
      id: 1,
      address: 'address1',
      dateOfBirth: '1970-11-07',
      email: 'email1',
      idCard: '456231786',
      name: 'name1',
      phoneNumber: '0901234121',
      salary: 10000000,
      division: this.division1,
      educationDegree: this.educationDegree3,
      position: this.position1,
    },
    {
      id: 2,
      address: '295 Nguyễn Tất Thành, Đà Nẵng',
      dateOfBirth: '1970-11-07',
      email: 'annguyen@gmail.com',
      idCard: '456231786',
      name: 'name2',
      phoneNumber: '0901234121',
      salary: 10000000,
      division: this.division1,
      educationDegree: this.educationDegree3,
      position: this.position1,
    },
    {
      id: 3,
      address: '295 Nguyễn Tất Thành, Đà Nẵng',
      dateOfBirth: '1970-11-07',
      email: 'annguyen@gmail.com',
      idCard: '456231786',
      name: 'name3',
      phoneNumber: '0901234121',
      salary: 10000000,
      division: this.division1,
      educationDegree: this.educationDegree3,
      position: this.position1,
    },
    {
      id: 4,
      address: '295 Nguyễn Tất Thành, Đà Nẵng',
      dateOfBirth: '1970-11-07',
      email: 'annguyen@gmail.com',
      idCard: '456231786',
      name: 'name4',
      phoneNumber: '0901234121',
      salary: 10000000,
      division: this.division1,
      educationDegree: this.educationDegree3,
      position: this.position1,
    },
    {
      id: 5,
      address: '295 Nguyễn Tất Thành, Đà Nẵng',
      dateOfBirth: '1970-11-07',
      email: 'annguyen@gmail.com',
      idCard: '456231786',
      name: 'name5',
      phoneNumber: '0901234121',
      salary: 10000000,
      division: this.division1,
      educationDegree: this.educationDegree3,
      position: this.position1,
    }
  ];

  villa: FacilityType = {id: 1, name: 'Villa'};
  house: FacilityType = {id: 2, name: 'House'};
  room: FacilityType = {id: 3, name: 'Room'};
  day: RentType = {id: 1, name: 'Day'};
  month: RentType = {id: 2, name: 'Month'};
  year: RentType = {id: 3, name: 'Year'};
  Hour: RentType = {id: 4, name: 'Hour'};
  facilityList: Facility[] = [
    {
      id: 1,
      name: 'Villa1',
      area: 1,
      cost: 1,
      maxPeople: 1,
      facilityType: this.villa,
      rentType: this.day,
      standarRoom: "vip",
      descriptionOtherConvenience: 'có mèo',
      poolArea: 15,
      numberOfFloors: 3
    },
    {
      id: 2,
      name: 'House2',
      area: 2,
      cost: 2,
      maxPeople: 2,
      facilityType: this.house,
      rentType: this.year,
      standarRoom: "vip",
      descriptionOtherConvenience: 'có mèo',
      numberOfFloors: 3
    },
    {
      id: 3,
      name: 'Room3',
      area: 3,
      cost: 3,
      maxPeople: 3,
      facilityType: this.room,
      rentType: this.month,
      facilityFree: 'Có khăn tắm'
    },
  ];

  attachFacility1: Attachfacility = {
    id: 1, cost: 100, name: 'name1', status: 'Model1', unit: 'hour'
  };
  attachFacility2: Attachfacility = {
    id: 2, cost: 50, name: 'name2', status: 'Model2', unit: 'hour'
  };
  attachFacility3: Attachfacility = {
    id: 3, cost: 10, name: 'name3', status: 'Model3', unit: 'hour'
  };
  attachFacility4: Attachfacility = {
    id: 4, cost: 200, name: 'name4', status: 'Model4', unit: 'hour'
  };

  contractList: Contract[] = [
    {
      id: 1,
      deposit: 0,
      startDate: '2020-12-08 00:00:00',
      endDate: '2020-12-08 00:00:00',
      customer: this.customerList[0],
      employee: this.employeeList[0],
      facility: this.facilityList[0]
    },
    {
      id: 2,
      deposit: 10,
      startDate: '2020-12-08 00:00:00',
      endDate: '2020-12-08 00:00:00',
      customer: this.customerList[1],
      employee: this.employeeList[1],
      facility: this.facilityList[1]
    },
    {
      id: 3,
      deposit: 20,
      startDate: '2020-12-08 00:00:00',
      endDate: '2020-12-08 00:00:00',
      customer: this.customerList[2],
      employee: this.employeeList[2],
      facility: this.facilityList[2]
    },
    {
      id: 4,
      deposit: 30,
      startDate: '2020-12-08 00:00:00',
      endDate: '2020-12-08 00:00:00',
      customer: this.customerList[3],
      employee: this.employeeList[3],
      facility: this.facilityList[1]
    },
    {
      id: 5,
      deposit: 40,
      startDate: '2020-12-08 00:00:00',
      endDate: '2020-12-08 00:00:00',
      customer: this.customerList[4],
      employee: this.employeeList[4],
      facility: this.facilityList[2]
    }
  ];

  contractDetailList: Contractdetail[] = [
    {id: 1, quantity: 1, attachFacility: this.attachFacility1, contract: this.contractList[0]},
    {id: 2, quantity: 2, attachFacility: this.attachFacility2, contract: this.contractList[1]},
    {id: 3, quantity: 3, attachFacility: this.attachFacility3, contract: this.contractList[2]},
    {id: 4, quantity: 4, attachFacility: this.attachFacility4, contract: this.contractList[3]},
    {id: 5, quantity: 5, attachFacility: this.attachFacility1, contract: this.contractList[4]}
  ];

  constructor() {
  }

  ngOnInit(): void {
  }

  currentContractDetail(target: any) {
  }

}
