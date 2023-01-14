import { Component, OnInit } from '@angular/core';
import {Customer} from "./customer";
import {CustomerType} from "./customer-type";

@Component({
  selector: 'app-cutomer-list',
  templateUrl: './cutomer-list.component.html',
  styleUrls: ['./cutomer-list.component.css']
})
export class CutomerListComponent implements OnInit {

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
  constructor() { }

  ngOnInit(): void {
  }

}
