import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  first_number: number;
  second_number: number;

  result: any = 0;


  constructor() {
  }

  ngOnInit(): void {
  }

  addition() {
    this.result = parseInt(String(this.first_number)) + parseInt(String(this.second_number));
    return this.result;
  }

  subtraction() {
    this.result = parseInt(String(this.first_number)) - parseInt(String(this.second_number));
    return this.result;
  }

  multiplication() {
    this.result = parseInt(String(this.first_number)) * parseInt(String(this.second_number));
    return this.result;
  }

  division() {
    if(this.second_number == 0){
      this.result = "Cannot be divided by 0!";
    }
    else {
      this.result = parseInt(String(this.first_number)) / parseInt(String(this.second_number));
      return this.result;
    }
  }
}
