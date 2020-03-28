import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import {DashboardRoutingModule} from "./dashboard.routing.module";
import {SharedModule} from "../../shared/shared.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

@NgModule({
    imports: [
        CommonModule,
        DashboardRoutingModule,
        SharedModule,
        NgxDatatableModule
    ],
  declarations: [DashboardComponent]
})
export class DashboardModule { }
