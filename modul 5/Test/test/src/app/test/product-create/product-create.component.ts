import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Product} from '../model/product';
import {TestService} from '../service/test.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {



  categoryFormGroup: FormGroup = new FormGroup(
    {
      number: new FormControl('', [Validators.required, Validators.min(0)]),
      productDay: new FormControl('', Validators.required),
      startDay: new FormControl('', Validators.required),
      endDay: new FormControl('', Validators.required),
      product: new FormControl('', Validators.required)
    }
  );
  productList: Product[] | undefined ;
  constructor(
  private  testService: TestService,
  private  activatedRoute: ActivatedRoute,
  private   router: Router) { }

  ngOnInit(): void {
    this.getAllProduct();
  }
getAllProduct(): void{
    this.testService.findAllProduct().subscribe(list => {
      this.productList = list;
    }, error => {
      console.log(error);
      }
      );
  }
  submit(): void {
    const category = this.categoryFormGroup.value;
    this.testService.add(category).subscribe(() => {
      this.categoryFormGroup.reset();
    }, error => {
      console.log(error);
    }, () => {
      this.router.navigateByUrl('');
      console.log('ok');
    });
  }
  compareWithId(item1: {id: any; }, item2: { id: any; }): boolean{
    return item1 && item2 && item1.id === item2.id;
  }
}
