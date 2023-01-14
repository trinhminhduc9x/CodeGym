import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { navigationComponent } from './component/navigation/navigation.component';
import { footerComponent } from './component/footer/footer.component';
import { facilityListComponent } from './component/facility/facility-list/facility-list.component';
import { facilityEditComponent } from './component/facility/facility-edit/facility-edit.component';
import { facilitySaveComponent } from './component/facility/facility-save/facility-save.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { CustomerSaveComponent } from './component/customer/customer-save/customer-save.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import { ContractSaveComponent } from './component/contract/contract-save/contract-save.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    navigationComponent,
    footerComponent,
    facilityListComponent,
    facilityEditComponent,
    facilitySaveComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerSaveComponent,
    ContractListComponent,
    ContractSaveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
