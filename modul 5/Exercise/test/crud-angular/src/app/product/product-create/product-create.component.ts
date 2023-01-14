import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Category} from "../model/category";
import {ProductService} from "../service/product.service";
import {Router} from "@angular/router";
import {Product} from "../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup;
  category: Category[] = [
    {id: 1, name: "IPhone"},
    {id: 2, name: "Samsung"},
    {id: 3, name: "LG"},
  ]

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private route: Router) {
    this.productForm = this.formBuilder.group({
      id: [''],
      name: [''],
      price: [''],
      description: [''],
      category: ['']
    });
  }

  ngOnInit(): void {
  }

  saveProduct() {
    let product: Product;
    product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(data => {
      this.route.navigateByUrl('/product/productList');
      this.productForm.reset();
    }, error => {
    }, () => {
    });


  }
}
