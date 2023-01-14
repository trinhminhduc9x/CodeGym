import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ImageGalleryModule} from './image-gallery/image-gallery.module';
import {GalleryConfig} from "./image-gallery/ token";
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ImageGalleryModule,
    NgxPaginationModule
  ],
  providers: [
    {provide: GalleryConfig, useValue: 3}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
