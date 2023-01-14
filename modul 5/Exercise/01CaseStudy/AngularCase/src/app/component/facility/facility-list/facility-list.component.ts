import { Component, OnInit } from '@angular/core';
import {FacilityType} from '../../model/facility/FacilityType';
import {RentType} from '../../model/facility/RentType';
import {Facility} from '../../model/facility/Facility';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {

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
      standarRoom: 'vip',
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
      standarRoom: 'vip',
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



  constructor() { }

  ngOnInit(): void {
  }

}
