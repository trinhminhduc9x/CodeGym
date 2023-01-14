import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  @Input()
  proudct: Product = {};
  private products: Product[] = [];


  constructor(private productService: ProductService, private  route: Router ) {

  }

  ngOnInit(): void {
  }



  deleteProduct() {
    this.productService.deleteById(this.proudct.id).subscribe(data => {

        console.log(this.proudct.id);
        document.getElementById('exampleModal')?.click();

      }
      , error => {
      }
      , () => {
      }
    );

  }
}
