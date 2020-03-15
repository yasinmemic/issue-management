import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IssueComponent } from './pages/issue/issue.component';
import {ProjectComponent} from "./pages/project/project.component";
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import { AppLayoutComponent } from './_layout/app-layout/app-layout.component';
import { FooterComponent } from './_layout/footer/footer.component';
import { HeaderComponent } from './_layout/header/header.component';
import { SidebarComponent } from './_layout/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    IssueComponent,
    ProjectComponent,
    DashboardComponent,
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
