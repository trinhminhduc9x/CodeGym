import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CategoryService} from '../../service/category.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('product')
  product: Product = {};
  productDeleteForm = new FormGroup({}) ;
  id: number | undefined;

  constructor(private productService: ProductService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      // @ts-ignore
      this.id = +paramMap.get('id');
      this.getProduct(this.id);
    });
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
  }

  // tslint:disable-next-line:typedef
  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.productDeleteForm = new FormGroup({
        name: new FormControl(product.name),
      });
    });
  }

  // tslint:disable-next-line:typedef
  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.router.navigate(['/product/list']);
    }, e => {
      console.log(e);
    });
  }

}
