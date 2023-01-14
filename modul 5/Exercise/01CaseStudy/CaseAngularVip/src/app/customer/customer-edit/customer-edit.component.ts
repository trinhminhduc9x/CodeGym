import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../customer-type";
import {CustomerServiceService} from "../service/customer-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import Swal from 'sweetalert2';


@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerFormGroup: FormGroup | undefined;
  customerId: number| undefined;
  customerTypeList: CustomerType[]| undefined;

  minAge = (new Date().getFullYear() - 80) + '-01-01';
  maxAge = (new Date().getFullYear() - 18) + '-12-31';


  constructor(private customerService: CustomerServiceService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.customerService.findAllCustomerType().subscribe(value => {
      this.customerTypeList = value;
    });

    this.customerId = Number(this.activatedRoute.snapshot.params.id);

    this.customerService.getById(this.customerId).subscribe(customer => {
      this.customerFormGroup = new FormGroup({
        customerName: new FormControl(customer.customerName, Validators.required),
        customerBirthday: new FormControl(customer.customerBirthday, this.checkMinAge18AndMaxAge80),
        customerGender: new FormControl(customer.customerGender, Validators.required),
        customerIdCard: new FormControl(customer.customerIdCard, [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
        customerPhone: new FormControl(customer.customerPhone, [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
        customerEmail: new FormControl(customer.customerEmail, [Validators.required, Validators.email]),
        customerAddress: new FormControl(customer.customerAddress, Validators.required),
        customerType: new FormControl(customer.customerType, Validators.required)
      });
    }, error => {
      console.log(error);
    }, () => {
      console.log('OK!');
    });
  }

  updateCustomer(id: number) {
    // @ts-ignore
    const customer = this.customerFormGroup.value;
    this.customerService.updateCustomer(id, customer).subscribe(() => {
      this.router.navigateByUrl('customer/list');
    }, error => {
      console.log(error);
    }, () => {
      console.log('Cập nhật khách hàng thành công!');
    });
  }

  checkMinAge18AndMaxAge80(abstractControl: AbstractControl): any {
    const formYear = Number(abstractControl.value.substr(0, 4));
    const curYear = new Date().getFullYear();

    return (curYear - formYear >= 18 && curYear - formYear <= 80) ? null : {invalid18_80: true};
  }

  compareWithId(item1: { id: any; }, item2: { id: any; }) {
    return item1 && item2 && item1.id === item2.id;
  }
}
