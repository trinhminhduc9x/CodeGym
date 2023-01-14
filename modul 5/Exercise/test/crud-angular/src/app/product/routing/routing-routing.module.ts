import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "../product-list/product-list.component";
import {ProductCreateComponent} from "../product-create/product-create.component";
import {ProductEditComponent} from "../product-edit/product-edit.component";

const routes: Routes = [
  {path:'product/productList',component: ProductListComponent},
  {path:'product/productCreate',component: ProductCreateComponent},
  {path:'product/productEdit/:id', component:ProductEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoutingRoutingModule { }
