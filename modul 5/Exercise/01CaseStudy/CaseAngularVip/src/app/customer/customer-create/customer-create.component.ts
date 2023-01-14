import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../customer-type";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerServiceService} from "../service/customer-service.service";


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {


  customerFormGroup: FormGroup = new FormGroup({
    customerName: new FormControl('', Validators.required),
    // customerBirthday: new FormControl('', this.checkMinAge18AndMaxAge80),
    customerGender: new FormControl('', Validators.required),
    customerIdCard: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
    customerPhone: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
    customerEmail: new FormControl('', [Validators.required, Validators.email]),
    customerAddress: new FormControl('', Validators.required),
    customerType: new FormControl('', Validators.required)
  });

  customerTypeList: CustomerType[] | undefined;

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
  }
  submit(): void {
    const customer = this.customerFormGroup.value;
    this.customerService.addCustomer(customer).subscribe(() => {
      this.customerFormGroup.reset();
    }, error => {
      console.log(error);
    }, () => {
      this.router.navigateByUrl('customer/list');
      console.log('Thêm mới khách hàng thành công!');
    });
  }
}
