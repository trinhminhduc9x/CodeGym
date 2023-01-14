import {Component,EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../model/product";
import {ProductService} from "../service/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  @Input('product') product: Product = {};

  constructor(private productService: ProductService, private route: Router) {
  }

  @Output() eventDelete = new EventEmitter();

  ngOnInit(): void {
  }

  deleteProduct(id: number | undefined) {

    console.log('id nè'+id)

    if (id != undefined) {
      this.productService.deleteProduct(id).subscribe(data => {
        this.eventDelete.emit();
      });
    }
  }
}
