import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Product} from "../model/product";
import {Category} from "../model/category";
import {ProductService} from "../service/product.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup = new FormGroup({});
  product: Product = {};
  category: Category[] = [
    {id: 1, name: 'IPhone'},
    {id: 2, name: 'Samsung'},
    {id: 3, name: 'LG'},
  ];

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private activatedRoute: ActivatedRoute, private route: Router) {
    this.productForm = this.formBuilder.group({
      id: [''],
      name: [''],
      price: [''],
      description: [''],
      category: ['']
    });
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if (id != null) {
        this.productService.findById(parseInt(id)).subscribe(data1 => {
          this.productForm.patchValue(data1);

        }, error => {
        }, () => {
        });
      }
    }, error => {

    }, () => {
    });
  }

  ngOnInit(): void {
  }

  compareCategory(o1: Category, o2: Category): boolean {
    return o1 && o2 ? o1.id === o2.id : o1 === o2;
  }

  updateProduct() {
    let product: Product;
    product = this.productForm.value;
    this.productService.updateProduct(product).subscribe(data => {
      this.productForm.reset();
      this.route.navigateByUrl('/product/productList');
      alert('Cập nhập thành công');
    }, error => {
    }, () => {
    });
  }
}
