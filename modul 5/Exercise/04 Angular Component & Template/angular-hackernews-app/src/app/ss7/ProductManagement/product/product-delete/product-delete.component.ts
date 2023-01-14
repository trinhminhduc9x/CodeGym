import { Component, OnInit } from '@angular/core';
import {Product} from "../product";
import {Category} from "../category";
import {CategoryService} from "../../category.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

class ProductServiceService {
}

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  productId: number;

  constructor(
    private productService: ProductServiceService,
    private activateRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.activateRoute.params.subscribe((params: Params) => {
      this.productId = params.productId;
    })
  }

  deleteProduct() {

    this.productService.deleteProduct(this.productId).subscribe(product => {
      this.router.navigateByUrl('/productList');
    })

  }

}
