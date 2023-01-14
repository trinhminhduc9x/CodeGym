import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './test/product-list/product-list.component';
import {ProductCreateComponent} from './test/product-create/product-create.component';

const routes: Routes = [
  {path: '', component: ProductListComponent}
  ,{path: 'create', component: ProductCreateComponent},
  // {path: 'edit/:id', component: ProductEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
