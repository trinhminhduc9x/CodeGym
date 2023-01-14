import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// import {DictionaryComponent} from "./ss7/dictionary/dictionary/dictionary.component";
// import {ViewComponent} from "./ss7/dictionary/view/view.component";
// import {ProductListComponent} from "./ss7/ProductManagement/product/product-list/product-list.component";
// import {ProductDeleteComponent} from "./ss7/ProductManagement/product/product-delete/product-delete.component";
// import {ProductEditComponent} from "./ss7/ProductManagement/product/product-edit/product-edit.component";
//
//


const routes: Routes = [
  // /*
  //  *  Dictionary - Từ điển
  //  * */
  // {path: '', component: DictionaryComponent},
  // {path: 'view/:word', component: ViewComponent},
  //
  // //product //
  // {path: 'productList', component: ProductListComponent},
  // {path: 'productCreate', component: ProductCreateComponent},
  // {path: 'productEdit/:productId', component: ProductEditComponent},
  // {path: 'productDelete/:productId', component: ProductDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
