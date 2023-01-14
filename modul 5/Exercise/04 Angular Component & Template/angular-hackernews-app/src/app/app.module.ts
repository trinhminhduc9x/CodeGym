import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ArticleComponent } from './article/article.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LikeComponent } from './like/like.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { RangtingComponent } from './ss5/rangting/rangting.component';
import { CountdownComponent } from './ss5/countdown/countdown.component';
import { FormComponent } from './ss6/form/form.component';
import { LoginformComponent } from './ss6/loginform/loginform.component';
// import { DictionaryComponent } from './ss7/dictionary/dictionary/dictionary.component';
// import { ViewComponent } from './ss7/dictionary/view/view.component';
// import { ProductListComponent } from './ss7/ProductManagement/product/product-list/product-list.component';
// import { EditComponent } from './ss7/ProductManagement/product/edit/edit.component';
// import { ProductEditComponent } from './ss7/ProductManagement/product/product-edit/product-edit.component';
// import { ProductUpdateComponent } from './ss7/ProductManagement/product/product-update/product-update.component';
// import { ProductDeleteComponent } from './ss7/ProductManagement/product/product-delete/product-delete.component';



@NgModule({
  declarations: [
    AppComponent,
    ArticleComponent,
    LikeComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    RangtingComponent,
    CountdownComponent,
    FormComponent,
    LoginformComponent,
    // DictionaryComponent,
    // ViewComponent,
    // ProductListComponent,
    // EditComponent,
    // ProductEditComponent,
    // ProductUpdateComponent,
    // ProductDeleteComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
